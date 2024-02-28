<template lang="en">
    <div>
        <div class="col-4 m-auto">
            <div class="card m-3">
            <h5 class="card-title">{{ taxReturn.form }} - {{ taxReturn.returnYear }}</h5>
            <div class="card-body">
                <p class="card-text">
                    You submitted {{ taxReturn.taxPayed }}€

                </p>
            </div>
        </div>
        </div>

        
    </div>
</template>
<script>
export default {
    props: ['taxReturn']   
}
</script>
<style lang="">
    
</style>