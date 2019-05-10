<template>
  <div class="add-new_wrapper">
    <div class="add-new">
      <div class="add-new__label">Введите название новой станции</div>
      <input type="text" id="add-new__input_station-name" class="add-new__input" name="name" required minlength="2" maxlength="30">
      <div class="add-new__label">Добавьте описание новой станции, если это необходимо</div>
      <textarea type="text" id="add-new__input_description" class="add-new__input add-new__input_description" name="name" required minlength="10"></textarea>
      <button class="button_medium">Сохранить</button>
    </div>
  </div>
</template>

<script>
    export default {
        name: "addNewStation"
    }
</script>

<style scoped>
  .add-new{
    display: flex;
    flex-direction: column;
    justify-content: center;
    height: 80vh;
  }
  .add-new__label{
    color:var(--green-medium);
    font-size: 20px;
    align-self: center;
    padding: 10px;
  }
  .add-new__input{
    border-style: solid;
    border-color: var(--green-lightest);
    border-width: 3px;
    border-radius: 5px;
    align-self: center;
    height: 50px;
    margin-bottom: 20px;
    width:400px;
    color:var(--green-light);
    font-size: 20px;
    text-align: center;
  }
  .add-new__input:focus,.add-new__input:hover{
    outline: none;
    border-color:var(--green-light);
  }

  .add-new__input_description{
    height: 150px;
  }
  .button_medium{
    color: var(--green-dark);
    font-size: 20px;
    border-style: solid;
    align-self: center;
    border-radius: 5px;
    border-color: var(--green-lightest);
    padding: 5px 10px 5px 10px;
    margin-top: 30px;
  }
  .button_medium:hover{
    outline: none;
    color:white;
    background-color: var(--green-lightest);
  }
  .button_medium:focus{
    border-color: var(--green-dark);
    background-color: var(--green-light);
    color:white;
    outline: none;
  }

</style>
