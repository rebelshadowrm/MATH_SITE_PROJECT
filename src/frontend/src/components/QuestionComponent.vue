<template>
  <form @submit.prevent="checkQuestion">
    <QuestionBox :questions="questions" />
    <input v-if="questions.length > 0" type="submit" value="submit"/>
  </form>
  <div class="answers">
    <div :class="result.answeredCorrect === true ? 'right' : 'wrong'"
         v-for="(result, index) in results" :key="result.id">
      <h2>Question {{index +1}}:</h2>
      <p>{{result.question.question}}</p>
    </div>
  </div>
</template>

<script>
import QuestionBox from "./QuestionBox";
import useUsers from "../composables/users";

export default {
  name: "QuestionComponent.vue",
  props: {
    questions: Array,
    results: Array,
  },
  components: {
    QuestionBox,
  },
  emits: ['submitted'],
  methods: {
    async checkQuestion(e) {
      const data = Object.fromEntries(new FormData(e.target))
      const drillCollection = this.questions
      const entries = Object.entries(data);
      const correctAnswers = []
      const answerResults = [];
      drillCollection.forEach((drill) => {
        const {id, correctAnswer} = drill
        correctAnswers.push([id, correctAnswer])
      })
      correctAnswers.forEach((ad) => {
        const test = entries.filter((e) =>  ad[0] == e[0])
        if(test.length > 0) {
          if (test[0][1] == ad[1]) {
            answerResults.push({
              "questionId":ad[0],
              "answerCorrect":true
            })
          } else {
            answerResults.push({
              "questionId":ad[0],
              "answerCorrect":false
            })
          }
        } else {
          answerResults.push({
            "questionId":ad[0],
            "answerCorrect":false
          })
        }
      })
      const {AuthHeader, getUsername} = useUsers()
      const options = AuthHeader('POST', JSON.stringify(answerResults))
      const res = await fetch(`/api/questions/${getUsername().value}`, options)
      this.$emit('submitted', res)
    },
  },
}
</script>

<style scoped>
form {
  display: flex;
  flex-direction: column;
  gap: 1.25rem;
  width: 100%;
}
input[type=submit] {
  place-self: start;
  background: hsl(var(--clr-primary-400) / .1);
  backdrop-filter: blur(7px);
  color: var(--clr-text);
  font-weight: 800;
  letter-spacing: 1px;
  font-size: var(--txt-lrg-fluid);
  padding: .35em 1.35em;
  border-radius: var(--radius);
  border: 1px solid hsl(var(--clr-accent-400) / .5);
  text-transform: capitalize;
  cursor: pointer;
  transition: background 300ms ease-out, border 300ms ease-out;
}
input[type=submit]:hover {
  background: hsl(var(--clr-white-200) / .1);
  border: 1px solid hsl(var(--clr-accent-400) / .85);
}
.answers {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}
.right,
.wrong {
  display: flex;
  flex-direction: row;
  gap: 0 2rem;
  align-items: center;
  padding: 1rem;
  font-size: var(--txt-med);
  font-weight: 500;
  border-radius: var(--radius);
  backdrop-filter: blur(7px);
  flex-wrap: wrap;
}
.right {
  background: hsl(var(--clr-accent-400) / .175);
  border: 1px solid hsl(var(--clr-accent-400) / .7);
}
.wrong {
  background: hsl(var(--clr-secondary-400) / .175);
  border: 1px solid hsl(var(--clr-secondary-400) / .7);
}
</style>