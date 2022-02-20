<template>
    <div :v-for="(question) in questions" :key="question.id" class="question-box">
      <p class="question">{{question.question}}</p>
      <div class="answer-box">
      <AnswerSelect
          :key="answer.id" v-for="answer in question.answers"
          :answer="answer.answer"
          :number="answer.id"
          :counter="question.id"
      />
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
<style>
.question-box {
  display: grid;
  gap: .5rem;
  border: 2px inset hsl(var(--clr-secondary-400));
  border-radius: 20px;
  padding: .5rem;
  color: var(--clr-text-dark);
  background-color: hsl(var(--clr-primary-400));
  font-weight: 700;
  max-width: 65ch;
}
.question {
  display: inline-block;
  padding: .5rem 1rem;
  background-color: hsl(var(--clr-primary-200));
  border-radius: 20px;
  font-weight: 500;
}
.answer-box {
  display: grid;
  /*grid-template-columns: max-content 1fr;*/
  gap: .5rem;
  padding: .5rem;
  border-radius: 20px;
  align-items: baseline;
}
.answer-box input {
  accent-color: hsl(var(--clr-secondary-400));
}
.answer-box label {
  display: inline-block;
  padding: .25rem;
  background-color: hsl(var(--clr-primary-200));
}
</style>
