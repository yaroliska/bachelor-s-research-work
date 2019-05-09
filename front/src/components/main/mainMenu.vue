<template>
  <div>
    <v-navigation-drawer class="v-nav" persistent :mini-variant="miniVariant" :clipped="clipped" v-model="drawer"
                         enable-resize-watcher fixed app>
      <v-list>
        <router-link to="comparisonOfModels" >
          <v-list-tile value="true" v-on:click="changeMainHeader('Сравнение моделей')">
            <v-list-tile-action>
              <v-icon>bar_chart</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>Сравнение моделей</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </router-link>

        <router-link to="constructorMainPage">
          <v-list-tile value="true" v-on:click="changeMainHeader('Конструирование')">
            <v-list-tile-action>
              <v-icon>create</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>Конструирование</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </router-link>

       <router-link to="userGuid">
          <v-list-tile value="true" v-on:click="changeMainHeader('Руководство пользователя')">
            <v-list-tile-action>
              <v-icon>school</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title >Руководство пользователя</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </router-link>
        <router-link to="aboutProgram" >
          <v-list-tile value="true" v-on:click="changeMainHeader('О программе')">
            <v-list-tile-action>
              <v-icon>train</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>О программе</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </router-link>
      </v-list>
    </v-navigation-drawer>
    <v-toolbar app :clipped-left="clipped">
      <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
      <v-btn icon @click.stop="miniVariant = !miniVariant">
        <v-icon v-html="miniVariant ? 'chevron_right' : 'chevron_left'"></v-icon>
      </v-btn>
      <v-btn icon @click.stop="clipped = !clipped">
        <v-icon>web</v-icon>
      </v-btn>
      <v-toolbar-title id="v-toolbar-title-header" >{{mainHeader}}</v-toolbar-title>
    </v-toolbar>
  </div>
</template>

<script>
  export default {

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
        title: 'Vuetify.js',
      }
    },
    computed:{
      mainHeader(){
        return this.$store.state.mainHeader;
      }
    },
    methods: {
      changeMainHeader:function (text) {
        this.$store.commit('changeMainHeader', text);
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
    background-color: var(--green-medium);
  }
  .v-nav{
    background-color: var(--green-dark)!important;
  }
  div.v-list__tile{
    color:white !important;
  }
  div.v-toolbar__content{
    color:white;
    background-color: var(--green-light) !important;
  }
  .theme--light{
    color:var(--white) !important;
  }
</style>
