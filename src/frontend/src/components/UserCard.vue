<template>
<div class="card">
  <div class="image">
    <img src="https://picsum.photos/350/400" />
  </div>
  <div class="user-info" v-for="(user,field) in users" :key="field" >
    <p class="field">{{field}}:</p>
    <p class="value">{{user.value}}</p>
  </div>
</div>
</template>

<script>
export default {
  name: "UserCard.vue",
}
</script>
<script setup>
import useUsers from '../composables/users.js'
const { loadUser, getFullName, getUsername, getEmail } = useUsers()
loadUser()
const users = {
  username : getUsername(),
  fullName : getFullName(),
  email : getEmail()
}
</script>

<style scoped>
.card {
  background-color: hsl(var(--clr-primary-400) / .1);
  backdrop-filter: blur(7px);
  border: 1px solid hsl(var(--clr-accent-400) / .5);
  display: grid;
  gap: 1rem;
  padding: 1rem 1.25rem 1.5rem 1.25rem;
  border-radius: var(--radius);
  width: max-content;
  max-width: 100%;
  max-height: max-content;
}
.image {
  background: transparent;
  border-radius: var(--radius);
  box-shadow:
      inset -10px 0 10px 0 hsl(var(--clr-accent-400) / .1),
      inset 0 -10px 10px 0 hsl(var(--clr-accent-400) / .1),
      inset 0 10px 10px 0 hsl(var(--clr-accent-600) / .2),
      inset 10px 0 10px 0 hsl(var(--clr-accent-600) / .2);
  /* to prevent screen resizing on load*/
  min-height: 400px;
  min-width: 350px;
}
.image img {
  border-radius: var(--radius);
  filter: opacity(.75);
  backdrop-filter: blur(7px);
  padding: .5rem;
}
.user-info {
  display: grid;
  grid-auto-flow: column;
  gap: 2rem;
  grid-template-columns: 40% 1fr;
}
.field {
  justify-self: end;
  text-transform: uppercase;
  font-weight: 200;
  letter-spacing: 1px;
}
.value {
  color: hsl(var(--clr-secondary-400));
  font-weight: 700;
}
</style>