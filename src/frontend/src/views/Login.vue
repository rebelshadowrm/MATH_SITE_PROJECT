<template>
  <div class="container">
    <Form :form="loginData" />
  </div>
</template>
<script>
import Form from '../components/Form.vue'
export default {
  name: 'Login',
  components: {
    Form,
  },
  data() {
    return {
      loginData: [
        {
          "id": 1,
          "name": "username",
          "type": "text",
          "length": 40
        },
        { "id": 2,
          "name": "password",
          "type": "text",
          "length": 40
        },
      ],
    }
  }
}
</script>
<style>
.container {
  display: grid;
  place-items: center;
  padding: 2rem;
}
</style>
