<template>
  <Header />
<main>
  <router-view/>
</main>
<Footer />
</template>
<script>
  import Header from './components/Header.vue'
  import Footer from './components/Footer.vue'
export default {
  name: 'App',
  components: {
    Header,
    Footer,
  },
  data() {
    return {
      username: '',
    }
  },
  methods: {
    async decodeJWT(token) {
      try {
        return JSON.parse(atob(token.split('.')[1]))
      } catch (e) {
        return null;
      }
    }
  },
  async created() {
    const access_token = localStorage.getItem('access_token')
    const {sub: username} = await this.decodeJWT(access_token)
    this.username = username
  }
}
</script>
<style>

</style>
