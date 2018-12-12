<template>
<div class="">
<h1 class="h1title">{{msg}}</h1>
<br>
<div class="inputSearch">
  <input type="text" v-model="searchinput" placeholder="   Search..."/>

  <button type="submit" @click.prevent="searchstring()"><font-awesome-icon icon="search" /></button>

<br><br>
  <b-row >
    <div class="col-md-4 col-lg4" v-for="i in posts" :key="i.id" :style="width='300px'">
      <b-col>
        <b-img
          v-bind:src="i.smallImageLocation" alt="No Photo" class="mainimage"/>
      </b-col>
      <br>
      <b-col>
      <a class="gotoDetail" href="#" @click.prevent="foodid(i.id)">
        <h1 class="h1">{{i.name}}</h1>
      </a>
      </b-col>
      <br>
      <b-col>
        <h4>{{i.ingredients}}</h4>
      </b-col>
      <br>
    </div>
  </b-row>
</div>
</div>

</template>
<script>
import axios from 'axios'

  export default {

    name: 'HelloWorld',
    props: {
      msg: String
      },
    data() {
    return {
      posts: [],
      searchinput:'',
      errors: [],
      }
    },
    methods: {
      searchstring(){

        axios.post('http://localhost:7777/search',{

         sendstring: this.searchinput
       })
          .then(response => {
             console.log(response.data);
             this.posts=response.data
          })
          .catch(e => {
            this.errors.push(e)
          })
        },
          foodid(id) {
            console.log(id);
            this.$store.commit('foodid', id)
            this.$router.push({
              name: 'recipedetail'
            })
          },

    }
}
</script>
<style scoped>

.h1title {
  font-size: 130px;
}

.inputSearch{
font-size: 70px;
width: auto;
height:90px;
padding-bottom: 1px;
}

.searchbtn{
  width: 80px;
  height:90px;
  padding-top: 17px;
  background-color: inherit;
}
.mainimage {
  border-radius: 50px;
}

.h1 {
  font-size: 50px
}
</style>
