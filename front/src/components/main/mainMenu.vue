<template>
  <div>
    <v-navigation-drawer persistent :mini-variant="miniVariant" :clipped="clipped" v-model="drawer"
                         enable-resize-watcher fixed app>
      <v-list>
        <router-link to="department">
          <v-list-tile value="true">
            <v-list-tile-action>
              <v-icon>group</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>Департаменты</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </router-link>
        <router-link to="student">
          <v-list-tile value="true">
            <v-list-tile-action>
              <v-icon>face</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>Студенты</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </router-link>
        <router-link to="editor">
          <v-list-tile value="true">
            <v-list-tile-action>
              <v-icon>video_label</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>Конструктор</v-list-tile-title>
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
      <v-toolbar-title>Привет, ЯРА !</v-toolbar-title>
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
        title: 'Vuetify.js'
      }
    },
    methods: {
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
    background-color: #F5F5F5;
  }
</style>
