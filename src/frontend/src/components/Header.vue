<template>
  <header>
      <h1>{{ title }}</h1>
      <Button 
        @btnClick="$emit('toggleAddMessage')" 
        :text="showAddMessage ? 'Close' : 'Add Message'" 
        :bgColor="showAddMessage ? 'red' : 'green'"
        :txtColor="showAddMessage ? '#222' : '#eee'" 
      />
  </header>
</template>

<script>
import Button from './Button.vue'
export default {
    name: 'Header',
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
header {
    padding: 1rem 3rem;
    display: grid;
    grid-auto-flow: column;
    align-items: center;
    gap: 3rem;
}
button {
    justify-self: end;
}
h1 {
    font-weight: 800;
    color: var(--clr-text-heading);
    font-size: 3rem;
}
</style>