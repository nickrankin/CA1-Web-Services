<template>
  <div class="container">
    <div class="row">
      <div class="col-12 m-auto">
        <h1 class="brand">Revenue Online Proof of Concept</h1>
        <hr>
        <div class="mb-4"></div>
    <LoginForm></LoginForm>

    <div class="mt-4"></div>
    <hr>
    <div class="foot">Nick Rankin 2024.</div>
      </div>

    </div>


  </div>
</template>


<script>
import LoginForm from './components/LoginForm.vue'

export default {
  name: 'App',
  data() {
    return {

    }
  },
  components: {
    LoginForm: LoginForm
  },
  methods: {

  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;

}
.brand {
  color: darkgreen;
  font-weight: bold;
  font-size: 3rem;

}
.foot {
    font-size: .9rem;
    color: darkgray;
  }
</style>
