<template>
  <h2>그동안 뭐 한거지? ㅎㅎ</h2>
  <div>
     {{ date3 }}
  </div>
</template>

<script setup>    //setup함수호출식
   const date3 = Date().toString()
</script>
