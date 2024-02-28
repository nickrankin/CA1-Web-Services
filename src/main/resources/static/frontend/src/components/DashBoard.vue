<template lang="en">
    <div>
        <div>

            <a href="#" class="btn btn-success m-4" @click="this.toggleForm()">Submit New Return</a>

            <div v-if="this.showForm">
                <div class="col-4">
                    <form>        
                    <label for="form" class="form-label">Select a Form and year:</label>            

                    <div class="input-group mb-3">

                    <select name="form" id="form" class="form-control m-4" v-model="selectedForm">
                        <option disabled value="">Please select one</option>
                        <option v-for="form in this.forms" :value="{
                            name: form.name,
                            year: form.year
                        }"  >{{ form.name }} - Year End {{ form.year }}</option>
                    </select>
                    </div>
                    <label for="totalTaxPaid" class="form-label">Total payment</label>

                    <div class="input-group mb-3">

                    <span class="input-group-text" >€</span>
                        <input type="text" name="totalTaxPayed" id="totalTaxPayed" class="form-control" v-model="totalTaxPayed" >
                    </div>

                    <a @click="submitTaxForm()" class="btn btn-primary m-3">Submit Return</a>

                </form>
                </div>

            </div>
            
            <MyReturns :taxReturns="this.taxReturns"></MyReturns>

        </div>
    </div>
</template>
<script>

import MyReturns from './MyReturns.vue'

export default {
    data() {
        return {
            forms: null,
            taxReturns: null,
            showForm: false,
            selectedForm: '',
            totalTaxPayed: 0,
            formError: ''

        }
    },
    components: {
        MyReturns: MyReturns
    },
    props: ['user'],
    methods: {
        toggleForm() {
            if (this.showForm) {
                this.showForm = false
            } else {
                this.showForm = true
            }
        },

        async getForms() {

            const result = fetch(this.$hostName + '/forms',
                {
                    method: "GET",
                })

            const response = await result

            if (response.status == 200) {
                response.json().then(forms =>
                    this.forms = forms
                )
                this.formError = ''

            } else {
                // Something wrong here
                response.text().then(errorText =>
                    this.formError = errorText
                )

            }
        },
        async submitTaxForm() {
        const formData = {
            "userId": this.user.id,
            "form": this.selectedForm.name,
            "returnYear": this.selectedForm.year,
            "taxPayed": this.totalTaxPayed
        }

        const result = fetch(this.$hostName + '/returns',
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(formData)

            })

        const response = await result

        this.toggleForm()

        if (response.status == 200) {
            // We logged in ok
            response.json().then( taxReturn =>
                this.taxReturns.push(taxReturn)
            )
            this.error = ''

        } else {
            // Something wrong here
            response.text().then(errorText =>
                this.error = errorText
            )
        }
    },
    },


    mounted() {
        this.getForms()
        this.taxReturns = this.user.returns
    }
}
</script>
<style lang="">

</style>