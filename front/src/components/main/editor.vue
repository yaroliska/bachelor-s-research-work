<template>
    <div class="wrapper">
      <canvas_editor></canvas_editor>
    </div>
</template>

<script>
  import canvas_editor from './canvas_editor.vue';

    export default {
      components: {
        'canvas_editor': canvas_editor
      },
      data() {
        return {
          component: 'editor'
        }
      }
    }
</script>

<style scoped>

</style>
