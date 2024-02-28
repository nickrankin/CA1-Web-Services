<template lang="en">
    <div v-if="this.user == null">
        <div class="row">
            <div class="m-auto">
            <div class="col-6">

                <div class="alert alert-danger" v-if="this.error != ''">An error occurred! {{ this.error }}</div>

                <label for="pps">PPS Number</label>
                <input type="text" name="pps" id="pps" v-model="pps_no" class="form-control m-2">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" v-model="pin" class="form-control m-2">

                <a href="#" class="btn btn-primary m-2" @click="doLogin()">Login</a>
            </div>
        </div>

        </div>


    </div>

    <div v-else>
        <div class="row">
            <div class="col-6">
                <h4>Thank you for logging in, {{ this.user.name }}!</h4>

            </div>
            <div class="col-4">
                <a href="#" class="btn btn-danger" @click="logout()">Logoff</a>

            </div>
        </div>

        <DashBoard :user="this.user"></DashBoard>


    </div>

</template>
<script>
import DashBoard from './DashBoard.vue'


export default {
    data() {
        return {
            user: null,
            error: ''
        }
    },
    components: {
        DashBoard: DashBoard,
    },
    methods: {
        async doLogin() {
            const loginData = new FormData();
            loginData.append('pps_no', this.pps_no);
            loginData.append('pin', this.pin);


            const result = fetch(this.$hostName + '/users/login',
                {
                    method: "POST",
                    body: loginData

                })

            const response = await result

            if (response.status == 200) {
                // We logged in ok
                response.json().then(user =>
                    this.user = user
                )
                this.error = ''

            } else {
                // Something wrong here
                response.text().then(errorText =>
                    this.error = errorText
                )

                this.user = null
            }

        },

        logout: function () {
            this.user = null
        }



    },

}
</script>
<style lang="">
    
</style>