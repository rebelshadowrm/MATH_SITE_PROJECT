<template>
<div class="container">
      <h1>{{ title }}</h1>
      <Button
        @btnClick="$emit('toggleAddMessage')" 
        :text="showAddMessage ? 'Close' : 'Add Message'" 
        :bgColor="showAddMessage ? 'red' : 'green'"
        :txtColor="showAddMessage ? '#222' : '#eee'" 
      />
</div>
</template>

<script>
import Button from '../Button.vue'
export default {
    name: 'Toggle',
    props: {
        title: String,
        showAddMessage: Boolean,
    },
    components: {
        Button
    },
}
</script>

<style scoped>
.container {
  padding: 1rem 2rem;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  gap: 1.5rem;
  width: 100%;
}
button {
  justify-self: end;
}
h1 {
  font-size: var(--txt-lrg);
}
</style>