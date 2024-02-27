<template lang="en">
    <div>
        <div>
            {{ this.forms }}

            {{ this.user }}
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            forms: null,

        }
    },
    props: ['user'],
    methods: {
        async getForms() {
      
            const result = fetch(this.$hostName + '/forms',
                {
                    method: "GET",
                })

            const response = await result

            if (response.status == 200) {
                // We logged in ok
                response.json().then(forms =>
                    this.forms = forms
                )
                this.error = ''

            } else {
                // Something wrong here
                response.text().then(errorText =>
                    this.error = errorText
                )

            }
        }
    },
    mounted() {
        this.getForms()
        console.error(this.user)
    }
}
</script>
<style lang="">

</style>