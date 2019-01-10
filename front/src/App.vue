<template>
  <v-app>
    <v-content>
      <router-view/>
    </v-content>
    <my-footer></my-footer>
  </v-app>
</template>

<script>

  import myfooter from './components/my-footer.vue';

  export default {
    components: {
      'my-footer': myfooter
    },
    data() {
      return {
        component: 'main-view'
      }
    }
  }
</script>

<style>

</style>
