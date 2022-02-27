<template>
  <div class="drills-container">
    <h1>Drills</h1>
    <SubjectChoice v-if="subjects.length === 0" @onSubmit="onSubmit"/>
    <QuestionComponent v-else :questions="questions" :results="results" @submitted="submitted"/>
  </div>
</template>

<script>
import QuestionComponent from "../components/QuestionComponent";
import SubjectChoice from "../components/SubjectChoice";
import useUsers from "../composables/users";
export default {
    name: "Drills",
    async created(){
      document.title = "Drills"
    },
  components: {
    QuestionComponent,
    SubjectChoice,
  },
  data() {
      return {
        questions: [],
        results: [],
        subjects: [],
        numberOfQuestions: 0,
        questionGenArray: [],
      }
  },
  methods: {
    async onSubmit(e) {
      try {
        const data = Object.fromEntries(new FormData(e.target))
        const {numOfQuestions, multiplication, division, addition, subtraction} = data
        if (numOfQuestions > 0) {
          this.numberOfQuestions = numOfQuestions
        }
        if (multiplication == 'on') {
          this.subjects.push({"subject": "MULTIPLICATION"})
        }
        if (division == 'on') {
          this.subjects.push({"subject": "DIVISION"})
        }
        if (addition == 'on') {
          this.subjects.push({"subject": "ADDITION"})
        }
        if (subtraction == 'on') {
          this.subjects.push({"subject": "SUBTRACTION"})
        }
        const {AuthHeader, getUsername} = useUsers()
        const res = await fetch(`api/exp/user/${getUsername().value}`, AuthHeader('GET'))
        const json = await res.json()
        const {level} = json
        const difficulty = Math.min(Math.ceil(level / 2), 3)
        for (let i = 0; i < this.numberOfQuestions; i++) {
          const randomNumber = Math.floor(Math.random() * this.subjects.length);
          const randomDiffNumber = Math.floor(Math.random() * difficulty) + 1
          const json = {
            "subject": this.subjects[randomNumber].subject,
            "difficulty": randomDiffNumber
          }
          this.questionGenArray.push(json)
        }
      } catch(err) {
        console.log(err)
      } finally {
         await this.prepareDrills()
      }
    },
    async prepareDrills() {
      const {AuthHeader} = useUsers()
      const options = AuthHeader('POST', JSON.stringify(this.questionGenArray))
      const res = await fetch('/api/questions/generate', options)
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

<style  scoped>
.drills-container {
  margin: 0 auto;
  width: calc(100% - 4rem);
  max-width: 65ch;
}
h1 {
  margin-left: 1rem;
}
</style>
