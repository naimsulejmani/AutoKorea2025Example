class FeatureApp {
    constructor() {
        this.api = new FeatureApi();
        this.init();
    }

    init() {
        Swal.fire({
            position: "top-end",
            icon: "success",
            title: "Your work has been saved",
            showConfirmButton: false,
            timer: 1500
        });
        this.api.findAll().then(features => {
            console.table(features);
            this.showTable(features);
        }).catch((err) => {
            Swal.fire({
                title: 'Error!',
                text: 'Do you want to continue: ' + err,
                icon: 'error',
                confirmButtonText: 'Cool'
            })
        });
    }

    showTable(data) {
        //write HTML BODY
    }
}


document.addEventListener('DOMContentLoaded', () => {
    const app = new FeatureApp();
})