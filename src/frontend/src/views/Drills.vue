<template>
  <div class="drills-container">
    <h1>Drills</h1>
    <QuestionBox :questions="drills"/>
  </div>
</template>

<script>
import QuestionBox from "../components/QuestionBox";
export default {
    name: "Drills",
  components: {
      QuestionBox,
  },
  data() {
    return {
      drills: [
        {
          "id":1, "question":"test question 1 test question 1 test question 1 test question 1 test question 1 test question 1 test question 1 test question 1 test question 1 test question 1 test question 1 ",
          "answers":[
              {
                "id":1,
                "answer":"this is answer 1",
                "correct":true
              },
            {
              "id":2,
              "answer":"this is answer 2",
              "correct":false
            },
            {
              "id":3,
              "answer":"this is answer 3",
              "correct":false
            },
            {
              "id":4,
              "answer":"this is answer 4",
              "correct":false
            }
          ]
        },
        {
          "id":2, "question":"test question 2 test question 2 test question 2 test question 2 test question 2 test question 2 test question 2 test question 2 test question 2 test question 2 test question 2 ",
          "answers":[
            {
              "id":1,
              "answer":"this is answer 1",
              "correct":true
            },
            {
              "id":2,
              "answer":"this is answer 2",
              "correct":false
            },
            {
              "id":3,
              "answer":"this is answer 3",
              "correct":false
            },
            {
              "id":4,
              "answer":"this is answer 4",
              "correct":false
            }
          ]
        },
        {
          "id":3, "question":"test question 3 test question 3 test question 3 test question 3 test question 3 test question 3 test question 3 test question 3 test question 3 test question 3 test question 3 ",
          "answers":[
            {
              "id":1,
              "answer":"this is answer 1",
              "correct":true
            },
            {
              "id":2,
              "answer":"this is answer 2",
              "correct":false
            },
            {
              "id":3,
              "answer":"this is answer 3",
              "correct":false
            },
            {
              "id":4,
              "answer":"this is answer 4",
              "correct":false
            }
          ]
        }
      ]
    }
  },
}
</script>

<style>
.drills-container {
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  gap: 2rem;
  padding: 1rem;
}
h1 {
  margin-left: 1rem;
}
</style>
