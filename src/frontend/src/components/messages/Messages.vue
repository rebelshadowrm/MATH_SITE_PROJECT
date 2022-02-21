<template>
<div class="messages">
  <div class="message" :key="message.id" v-for="message in messages">
      <Message @delete-message="$emit('deleteMessage', message.id)" :message="message" />
  </div>
</div>
</template>

<script>
import Message from './Message.vue'

export default {
    name: "Messages",
    props: {
        messages: Array
    },
    components: {
        Message,
    },
    emits: ['deleteMessage'],
}
</script>

<style scoped>
.message {
  border: 1px solid hsl(var(--clr-white-200) / .3);
  background: hsl(var(--clr-white-400) / .1);
  backdrop-filter: blur(7px);
  border-radius: var(--radius);
  padding: 1.7rem 1rem;
  display: grid;
  grid-auto-flow: column;
  align-items: baseline;
  gap: 1rem;
  font-size: var(--txt-med);
  font-weight: 700;
}
.messages {
  display: grid;
  gap: 1.7rem;
  padding: 1.7rem;
}
</style>