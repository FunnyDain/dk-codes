<template>
  <div class="work">
    <h1>다이니의 Vue실습 페이지</h1>
    <div class="flexBox">
      <TeamCard v-for="(teamMember, index) in teamMembers"
                :key="teamMember.id"
                :name="teamMember.name"
                :food="teamMember.food"
                :src-url="teamMember.srcUrl"
                :index="index"
                @delete-member="deleteMember"
      ></TeamCard>
    </div>
  </div>

</template>

<script>
import TeamCard from "@/components/TeamCard.vue";
import {defineComponent} from "vue";

export default defineComponent({
  components: {TeamCard},
  data(){
    return {
      teamMembers: [
        { id: 1, name: "최정우", food: "햄버거", srcUrl: "/images/최정우.jpg" },
        { id: 2, name: "김태현", food: "샌드위치", srcUrl: "/images/김태현.jpg" },
        { id: 3, name: "김주영", food: "치킨", srcUrl: "/images/김주영.jpg" },
        { id: 4, name: "신다인", food: "고기,떡볶이", srcUrl: "/images/신다인.jpg" },
      ]
    }
  },
  methods: {
    deleteMember(index){
      this.teamMembers.splice(index,1);
    }
  }
})

</script>

<style>
.flexBox{
  max-width: 1000px;
  display: flex;
  margin: auto;
}
</style>