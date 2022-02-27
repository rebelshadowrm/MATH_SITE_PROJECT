<template>
  <div class="test-container">
    <h1>Test</h1>
    <QuestionComponent :questions="questions" :results="results" @submitted="submitted"/>
  </div>
</template>

<script>
import QuestionComponent from "../components/QuestionComponent";
import useUsers from "../composables/users";
export default {
  name: "Test",
  created(){
    document.title = "Tests"
  },
  components: {
    QuestionComponent,
  },
  data() {
    return {
      questions: [],
      results: []
    }
  },
  mounted() {
    this.prepareDrills()
  },
  methods: {
    async prepareDrills() {
      const {AuthHeader} = useUsers()
      const res = await fetch('/api/questions/by/teacher', AuthHeader('GET'))
      this.questions = await res.json()
    },
    async submitted(response) {
      if(response.status === 201) {
        const json = await response.json()
        console.log("Success: ", json)
        this.questions = []
        json.forEach((el) => {
          const {question, answeredCorrect} = el
          this.results.push({question, answeredCorrect})
        })

      } else {
        console.log("Error: ",response.status)
      }
    }
  }
}
</script>

<style scoped>
.test-container {
  margin: 0 auto;
  width: calc(100% - 4rem);
  max-width: 65ch;
}
h1 {
  font-size: var(--txt-xlrg-fluid);
  font-family: var(--ff-serif);
  letter-spacing: 2px;
  color: hsl(var(--clr-white-200) / .1);
  -webkit-text-stroke: 1px hsl(var(--clr-accent-400) / .75);
}
</style>
