angular.module('frontendApp')
    .filter('nullable', function () {
        return function (input, noZero) {
            if (input == undefined || (noZero && parseInt(input) == 0)) {
                return "-";
            }
            return input;
        };
    })
    .filter('kw', ['numberFilter', function ($number) {
        return function (input) {
            return input + " kW"
        };
    }])
    .filter('nm', ['numberFilter', function ($number) {
        return function (input) {
            return input + " Nm"
        };
    }])
    .filter('weight', ['numberFilter', function ($number) {
        return function (input) {
            if (!input) {
                return null;
            }
            return $number(input) + " kg"
        };
    }])
    .filter('engineSize', ['numberFilter', function ($number) {
        return function (input) {
            if (!input || input == "-") {
                return null;
            }
            return $number(input) + " cc"
        };
    }])
    .filter('engineLocation', function () {
        var locationMap = {
            "FRONT": "front",
            "REAR": "rear",
            "MID_REAR": "rear mid",
            "MID_FRONT": "front mid"
        };
        return function (input) {
            if (!input || !locationMap[input]) {
                return null;
            }
            return locationMap[input];
        };
    })
    .filter('deliveryMethod', function () {
        var map = {
            "ELECTRONIC_SEQ": "sequential electronic",
            "ELECTRONIC": "electronic",
            "MECHANICAL": "mechanical"
        };
        return function (input) {
            if (!input || !map[input]) {
                return null;
            }
            return map[input];
        };
    })
    .filter('fuelDelivery', function () {
        var map = {
            "DIRECT_INJECT": "direct injection",
            "MULTI_POINT_INJECT": "multi-point injection",
            "SINGLE_POINT_INJECT": "single-point injection",
            "DIRECT_MULTI_POINT_INJECT": "direct multi-point injection",
            "CARB_SINGLE": "single carb",
            "CARB_MULTI": "multi-carb"
        };
        return function (input) {
            if (!input || !map[input]) {
                return null;
            }
            return map[input];
        };
    })
    .filter('engineConfiguration', function () {
        var map = {
            "INLINE": "inline",
            "V": "V",
            "V90": "V90",
            "V60": "V60",
            "V65": "V65",
            "V15": "V15",
            "V75": "V75",
            "V72": "V72",
            "HORIZONTAL": "horizontal",
            "W72_15": "W72/15"
        };
        return function (input) {
            if (!input || !map[input]) {
                return null;
            }
            return map[input];
        };
    })
    .filter('induction', function () {
        var map = {
            "NA": "na",
            "TURBO": "turbo",
            "TURBO_INTERCOOLED": "intercooled turbo",
            "TWIN_TURBO_INTERCOOLED": "intercooled twin turbo",
            "TRIPLE_TURBO_INTERCOOLED": "intercooled triple turbo",
            "SUPERCHARGED": "supercharged",
            "SUPERCHARGED_INTERCOOLED": "intercooled supercharged",
            "TWIN_SUPERCHARGED_INTERCOOLED": "intercooled twin supercharged",
            "TURBO_SUPERCHARGED_INTERCOOLED": "intercooled turbo supercharged"
        };
        return function (input) {
            if (!input || !map[input]) {
                return null;
            }
            return map[input];
        };
    })
    .filter('camType', function () {
        var map = {
            "DOHC": "DOHC",
            "DOHC_VVT": "DOHC & VVT",
            "DOHC_VVT_LIFT": "DOHC & VVT & Lift",
            "OHC": "OHC",
            "OHC_VVT": "OHC & VVT",
            "OHC_VVT_LIFT": "OHC & VVT & Lift",
            "PUSHROD": "pushrod",
            "PUSHROD_VVT": "pushrod & VVT"
        };
        return function (input) {
            if (!input || !map[input]) {
                return null;
            }
            return map[input];
        };
    })
    .filter('engineType', function () {
        var map = {
            "PISTON": "piston",
            "PISTON_ELECTRIC": "piston electric (hybrid)",
            "ROTARY": "rotary",
            "ELECTRIC": "electric"
        };
        return function (input) {
            if (!input || !map[input]) {
                return null;
            }
            return map[input];
        };
    })
    .filter('cylinders', function () {
        return function (input) {
            if (!input) {
                return null;
            }
            return input + " cylinders";
        };
    })
    .filter('transmission', function () {
        var map = {
            "MANUAL": "manual",
            "MANUAL_AUTOCLUTCH": "manual auto-clutch",
            "AUTO": "automatic",
            "DUAL_CLUTCH_AUTO": "dual-clutch automatic",
            "SEQUENTIAL_MANUAL": "sequential manual",
            "DUAL_CLUTCH_SEQUENTIAL_MANUAL": "dual clutch sequential manual",
            "CVT": "CVT",
            "REDUCTION_GEAR": "reduction gear"
        };
        return function (input) {
            if (!input || !map[input]) {
                return null;
            }
            return map[input];
        };
    });



    