<template>
<div>
  <label :for="name">{{name}}</label>
  <input :id="name" :type="type" :maxlength="max" />
</div>
</template>
<script>
export default {
  name: 'TextInput',
  props: {
    name: String,
    type: String,
    max: Number,
  }
}
</script>
<style>
div {
  display: flex;
  flex-direction: column;
  gap: .5rem;
}
input[type=text] {
  font-size: 1.75rem;
  padding: .5rem .75rem;
  border-radius: var(--radius);
}
label {
  margin-left: .5rem;
  font-size: 2rem;
  font-weight: 700;
  text-transform: capitalize;
}
</style>
