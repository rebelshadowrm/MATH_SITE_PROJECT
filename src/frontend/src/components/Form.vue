<template>
<form>
  <h1>Login</h1>
    <TextInput
        :key="input.id" v-for="input in form"
        :name="input.name"
        :type="input.type"
        :length="input.length"
    />
  <input type="submit" value="login"/>
</form>
</template>
<script>
import TextInput from "@/components/TextInput";
export default {
  name: 'Form',
  props: {
    form: Array,
  },
  components: {
    TextInput
  },
}
</script>
<style>
form {
  background: hsl(var(--clr-secondary-200), .25);
  display: grid;
  gap: 1.5rem;
  padding: 2rem;
  min-height: 30rem;
  border-radius: var(--radius);
  max-width: 50ch;
  width: 100%;
}
input[type="submit"] {
  place-self: start;
  font-size: 1.75rem;
  padding: .75rem 1.9rem;
  border-radius: var(--radius);
  cursor: pointer;
  margin-left: .5rem;
}
</style>
