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
    font-size: var(--txt-lrg);
}
</style>