<template>
  <div class="wrapper">
    <form class="form-inline">
      <div class="form-group mx-sm-3 mb-2">
        <input  class="form-control"  v-model="student.firstName" placeholder="Имя">
        <input style="margin: 0 0 0 30px" class="form-control"  v-model="student.lastName" placeholder="Фамилия">
        <input style="margin: 0 0 0 30px" class="form-control" type="number"  v-model="student.age" placeholder="Возраст">
        <select style="margin: 0 0 0 30px"  class="form-control" v-model="student.department">
          <option value="" disabled selected>Группа</option>
          <option v-for="department in departments" v-bind:value="department">
            {{ department.number }}
          </option>
        </select>
        <button style="margin: 0 0 0 30px" @click.prevent="addStudent" class="btn btn-primary">
          Добавить студента
        </button>
      </div>
    </form>
    <div class="tableDiv">
      <table class="table table-striped table-hover">
        <thead class="thead-light">
        <tr>
          <th style="width: 95px" scope="col">ID</th>
          <th style="width: 288px" scope="col">Имя</th>
          <th style="width: 193px" scope="col">Фамилия</th>
          <th style="width: 193px" scope="col">Возраст</th>
          <th style="width: 193px" scope="col">Группа</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="s in students">
          <td style="width: 95px">{{s.id}}</td>
          <td style="width: 288px">{{s.firstName}}</td>
          <td style="width: 193px">{{s.lastName}}</td>
          <td style="width: 193px">{{s.age}}</td>
          <td style="width: 193px">{{s.department.number}}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
  import {bus} from '../../main';

  const axios = require('axios');

  export default {
    data() {
      return {
        departments: [],
        students: [],
        student: {
          firstName: '',
          lastName: '',
          age: '',
          department:''
        },
      }
    },
    methods: {
      getDepartments: function () {
        var self = this;
        axios.get('http://localhost:8081/api/department')
          .then(function (response) {
            self.departments = response.data;
          })
          .catch(function (error) {
            console.log(error);
          })
      },
      getStudents: function () {
        var self = this;
        axios.get('http://localhost:8081/api/student')
          .then(function (response) {
            console.log(response.data);
            self.students = response.data;
          })
          .catch(function (error) {
            console.log(error);
          })
      },
      addStudent: function () {
        var self = this;
        console.log(this.timetable);
        axios.post('http://localhost:8081/api/student', this.student)
          .then(function (response) {
            console.log(response);
            self.getStudents();
            self.student.firstName = '';
            self.student.lastName = '';
            self.student.age = '';
            self.student.department = '';
          })
          .catch(function (error) {
            console.log(error);
          });
      },
    },
    created: function () {
      this.getDepartments();
      this.getStudents();
    }
  }
</script>

<style>
  form {
    margin: 30px;
  }

  .tableDiv {
    margin: 0 639px 0 30px;
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
