<template>
  <div>저는 Composition API를 사용한 자식 컴포넌트입니당.. 콘솔창에서 결과 보세요..</div>
</template>
<script>
import { onMounted } from 'vue'
export default {
  emits: ['send-message'],
  setup(props, context) {   //set함수 정의시 매개변수 가능, context안에 emit이라는 함수 내장
    const msg = 'Composition API를 사용한 자식 컴포넌트로부터 보내는 메시지';
    const { emit } = context;   //구조분해 할당,context에 emit만 꺼냄
    onMounted(() => {
      emit('send-message', msg)
    })
  }
}
</script>