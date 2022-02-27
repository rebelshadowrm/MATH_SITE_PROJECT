<template>
  <div class="flashcards-container">
    <h1>Flashcards</h1>
    <SubjectChoice v-if="subjects.length === 0" @onSubmit="onSubmit"/>
    <div v-else class="card-container">
      <Flashcard
          :key="flashcard.id" v-for="flashcard in this.flashcards"
          :question="flashcard.question"
          :answer="flashcard.answer"
          :id="flashcard.id"
      />
    </div>
  </div>
</template>

<script>
import Flashcard from '../components/Flashcard'
import SubjectChoice from "../components/SubjectChoice";
import useUsers from "../composables/users";
export default {
    name: "Flashcards",
    created(){
      document.title = "Flashcards"
    },
    components: {
      SubjectChoice,
      Flashcard,
    },
    data() {
      return {
        flashcards: [],
        subjects: [],
        numberOfQuestions: 0,
        questionGenArray: [],
      }
    },
    mounted() {
      this.prepareFlashcards()
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
          await this.prepareFlashcards()
        }
      },
      async prepareFlashcards() {
        const {AuthHeader} = useUsers()
        const options = AuthHeader('POST', JSON.stringify(this.questionGenArray))
        const res = await fetch('/api/questions/generate', options)
        const data = await res.json()
        data.forEach((el) => {
          let answer
          switch(el.correctAnswer) {
            case 1: {
              answer = el.answer1
              break;
            }
            case 2: {
              answer = el.answer2
              break;
            }
            case 3: {
              answer = el.answer3
              break;
            }
            case 4: {
              answer = el.answer4
              break;
            }
            default: {
              answer = ""
              break;
            }
          }
          const flashcard = {
            "id":el.id,
            "question": el.question,
            "answer": answer
          }
          this.flashcards.push(flashcard)
        })

    },
  }
}
</script>

<style  scoped>
h1 {
  align-self: center;
  font-size: var(--txt-xlrg-fluid);
  font-family: var(--ff-serif);
  letter-spacing: 2px;
  color: hsl(var(--clr-white-200) / .1);
  -webkit-text-stroke: 1px hsl(var(--clr-accent-400) / .75);
}
.flashcards-container {
  padding: 2rem;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  gap: 3rem;
  max-width: 75rem;
}
.card-container {
  margin: 0 auto;
  display: flex;
  flex-wrap: wrap;
  gap: 3rem 2rem;
  justify-content: center;
}
</style>
