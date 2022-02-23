<template>
<div class="card-container">
  <Flashcard
      :key="flashcard.id" v-for="flashcard in this.flashcards"
      :question="flashcard.question"
      :answer="flashcard.answer"
      :id="flashcard.id"
  />
</div>
</template>

<script>
import Flashcard from '../components/Flashcard'
export default {
    name: "Flashcards",
    created(){
      document.title = "Flashcards"
    },
    components: {
      Flashcard,
    },
    data() {
      return {
        flashcards: [
          {
            "id": 1,
            "question": "this is question 1",
            "answer": "this is answer 1"
          },
          {
            "id": 2,
            "question": "this is question 2",
            "answer": "this is answer 2"
          },
          {
            "id": 3,
            "question": "this is question 3",
            "answer": "this is answer 3"
          },
          {
            "id": 4,
            "question": "this is question 4",
            "answer": "this is answer 4"
          },
          {
            "id": 5,
            "question": "this is question 5",
            "answer": "this is answer 5"
          },
        ],
      }
    },
  methods: {
      async mounted() {

      },
      async created() {

      }
  }
}
</script>

<style  scoped>
.card-container {
  padding: 3rem;
  display: grid;
  place-items: center;
  gap: 3rem;
}
</style>
