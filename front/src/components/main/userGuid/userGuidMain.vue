<template>
    
</template>

<script>
    export default {
      name: "userGuidMain",
      data() {

      },
      methods:{
        changeHeader: function() {
          // генерируем событие 'remove' и передаём id элемента
          this.$emit('change', 'Руководство пользователя');
        }
      },
      mounted:function () {
      }
    }
</script>

<style scoped>

</style>
