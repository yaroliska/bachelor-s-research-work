<template>
  <div>
    <main-menu></main-menu>
    <router-view/>
  </div>
</template>

<script>

  import mainMenu from '../main/mainMenu.vue';

  export default {
    components: {
      'main-menu': mainMenu
    },
    data() {
      return {
        clipped: false,
        drawer: true,
        fixed: false,
        items: [{
          icon: 'bubble_chart',
          title: 'Inspire'
        }],
        miniVariant: false,
        right: true,
        rightDrawer: false,
        title: 'Vuetify.js'
      }
    }
  }
</script>

<style>
  a {
    text-decoration: none;
  }

  a:hover {
    text-decoration: none;
  }

  div.v-list__tile:hover {
    background-color: var(--white);
  }
</style>
