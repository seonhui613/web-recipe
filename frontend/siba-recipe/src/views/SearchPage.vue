<template>
<div class="search">
    <searchComponents msg="Seon hui's Recipe Search" />
  </div>
</template>


<script>
// @ is an alias to /src
import searchComponents from '@/components/seachComponents.vue'

export default {
  name: 'searchpage',

  components: {
    searchComponents
  },


}
</script>
<style scoped>
</style>
