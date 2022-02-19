<template>
    <div :key="question.id" v-for="(question) in questions" class="question-box">
      <p class="question">{{question.question}}</p>
      <div class="answer-box">
        <span class="answer-input" :key="answer.id" v-for="answer in question.answers" >
          <AnswerSelect
              :answer="answer.answer"
              :number="answer.id"
              :counter="question.id"
          />
        </span>
      </div>
    </div>
</template>
<script>
import AnswerSelect from "./AnswerSelect";
export default {
  name: 'QuestionBox',
  props: {
    questions: Array,
  },
  components: {
    AnswerSelect,
  },
}

</script>
<style scoped>
.question-box {
  display: grid;
  max-width: 65ch;
  padding: 1.3rem;
  gap: 1.5rem;
  color: var(--clr-text);
  border: 2px solid hsl(var(--clr-accent-600) / .3);
  background-color: hsl(var(--clr-primary-200) / .1);
  backdrop-filter: blur(7px);
  font-weight: 700;
  border-radius: 20px;
}
.question {
  display: inline-block;
  padding: 1rem 1.5rem;
  background-color: hsl(var(--clr-secondary-600) / .7);
  border-radius: 20px;
  font-weight: 500;
  font-size: var(--txt-med);
}
.answer-box {
  display: grid;
  grid-auto-flow: row;
  gap: 1rem;
  border-radius: 20px;
}
.answer-input {
  display: grid;
  gap: .5rem;
  padding: .75rem 1rem;
  grid-template-columns: max-content 1fr;
  border-radius: 20px;
  align-items: baseline;
  background-color: hsl(var(--clr-secondary-600) / .5);
  font-size: var(--txt-small-fluid);
}
</style>
