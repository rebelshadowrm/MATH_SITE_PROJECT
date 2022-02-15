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
      
    }
  },
  methods: {

  },
}
</script>
<style>

</style>
