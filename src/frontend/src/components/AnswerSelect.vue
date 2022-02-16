<template>
  <input :id="'q'+counter+'answer'+number" :name="'question'+counter" type="radio" :value="number" />
  <label :for="'q'+counter+'answer'+number">{{ answer }}</label>
</template>
<script>
export default {
  name: 'AnswerSelect',
  props: {
    number: Number,
    answer: String,
    counter: Number,
  },
}
</script>
<style>

</style>
