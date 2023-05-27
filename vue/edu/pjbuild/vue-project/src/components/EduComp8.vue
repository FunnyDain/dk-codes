<template>
  메인보드의 가격: <input type="text" v-on:input="price = $event.target.value" v-bind:value="price">
</template> 

<script>
import { ref, watch } from 'vue'

export default {
  setup() {
    const price = ref(112053)

    watch(price, (cur, prev) => {   //(감시하고자 하는 객체,) : price가 변화하면 함수를 실행해라~
        console.log('price의 변경된 값 :', cur)
        console.log('price의 변경되기 전의 값 :', prev)
      },
      {
        immediate: true,    //처음에 만들어졌을 때도 즉시 수행해라
      }
    )

    return {
      price,
    }
  },
}
</script>
