<template lang="en">
    <div>
        <div class="m-4"></div>
        <h3>My completed returns</h3>

        <div class="col-10 m-auto">
            <div v-for="taxReturn in taxReturns">
                <TaxReturn :taxReturn="taxReturn"></TaxReturn>
            </div>
        </div>

    </div>
</template>
<script>

import TaxReturn from './TaxReturn.vue'

export default {
    data() {
        return {
        }
    },
    components: {
        TaxReturn: TaxReturn

    },
    props: ['taxReturns']
}
</script>
<style lang="">
    
</style>