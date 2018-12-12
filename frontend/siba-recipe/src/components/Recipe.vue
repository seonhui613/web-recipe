<template>
<div>
  <div class="hello">
    <h1 class="h1title">{{ msg }}</h1>

  </div>
  <br><br>

  <b-container>
    <b-row>
      <div class="col-md-4 col-lg4" v-for="list in posts.list" :key="list.id" :style="width='300px'">
        <b-col>
          <b-img v-bind:src="list.smallImageLocation" alt="food1" class="mainimage" />
        </b-col>

        <br>

        <b-col>
          <a class="gotoDetail" href="#" @click.prevent="foodid(list.id)">
            <h1 class="h1">{{list.name}}</h1>
          </a>
        </b-col>

        <br>

        <b-col>
          <h4>{{list.ingredients}}</h4>
        </b-col>
        <br>
      </div>
    </b-row>
    <b-pagination-nav class="page" align="center" size="lg" :link-gen="linkGen" :number-of-pages="63" v-model="currentPage" />
    <div class="mt-4">currentPage:{{currentPage}}</div>
  </b-container>
</div>
</template>
<!-- :use-router="true" -->
<!-- <script src="https://cdn.jsdelivr.net/npm/vue@2.5.2/dist/vue.js"></script>
  <script src="https://unpkg.com/axios/dist/axios.min.js"></script> -->

<script >
  import axios from 'axios'

// import pagination from 'vue-bootstrap-pagination'
export default {

  name: 'HelloWorld',
  props: {
    msg: String
  },
  data() {
    return {
      posts: [],
      errors: [],
      currentPage: 1,

      baseUrl: 'http://localhost:7777/food/list',
    }
  },
  methods: {
    linkGen(currentPage) {
      axios.get(this.baseUrl, {
          params: {
            page: currentPage
          }
        })
        .then(response => {
          this.posts = response.data
        })
        .catch(e => {
          this.errors.push(e)
        })
      return {
        path: '/food/list/?page=' + currentPage
      }
    },
    foodid(id) {
      console.log(id);
      this.$store.commit('foodid', id)
      this.$router.push({
        name: 'recipedetail'
      })
    },

  },

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.mainimage {
  border-radius: 50px;
}

.h1 {
  font-size: 50px
}

.h1title {
  font-size: 130px;
}
</style>
