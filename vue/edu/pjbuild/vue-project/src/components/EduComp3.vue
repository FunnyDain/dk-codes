<template>
	<div>
		<button @click="increment()">Counter: {{ counter }}</button>
	</div>
</template>

<script>
import { onMounted, ref } from 'vue';

export default {
	setup() {
		const counter = ref(0);   //ref()라는 함수, reactive()라는 함수를 통해 보관
		const increment = () => counter.value++;

    //v3화살표함수 지원
		onMounted(() => {
			console.log('애플리케이션이 마운트 되었습니다!');
		});
		return {
			counter,
			increment,
		};
	},
};
</script>