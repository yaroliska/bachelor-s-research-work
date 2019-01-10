<template>
  <div class="wrapper">
    <form class="form-inline">
      <div class="form-group mx-sm-3 mb-2">
        <input class="form-control"  v-model="department.number" placeholder="Номер группы">
        <button style="margin: 0 0 0 44px" @click.prevent="addDepartment" class="btn btn-primary">
          Добавить группу
        </button>
      </div>
    </form>
    <div class="tableDivDepartments">
      <table class="table table-striped table-hover">
        <thead class="thead-light">
        <tr>
          <th style="width: 95px" scope="col">ID</th>
          <th style="width: 288px" scope="col">Номер</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="d in departments">
          <td style="width: 95px">{{d.id}}</td>
          <td style="width: 288px">{{d.number}}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>

  const axios = require('axios');

  export default {
    data() {
      return {
        departments: [],
        department:{
          number:''
        }
      }
    },
    methods: {
      getDepartments: function () {
        var self = this;
        axios.get('http://localhost:8081/api/department')
          .then(function (response) {
            console.log(response.data);
            self.departments = response.data;
          })
          .catch(function (error) {
            console.log(error);
          })
      },
      addDepartment: function () {
        var self = this;
        console.log(this.timetable);
        axios.post('http://localhost:8081/api/department', this.department)
          .then(function (response) {
            console.log(response);
            self.getDepartments();
            self.department.number = '';
          })
          .catch(function (error) {
            console.log(error);
          });
      },
    },
    created: function () {
      this.getDepartments();
    }
  }
</script>

<style>
  form {
    margin: 30px;
  }

  .tableDivDepartments {
    margin: 0 1199px 0 30px;
  }

  table.scroll {
    border-spacing: 0;

  }

  table.scroll tbody,
  table.scroll thead tr { display: block; }

  table.scroll tbody {
    height: 350px;
    overflow-y: auto;
    overflow-x: hidden;
  }

  tbody td:last-child, thead th:last-child {
    border-right: none !important;
  }
</style>
