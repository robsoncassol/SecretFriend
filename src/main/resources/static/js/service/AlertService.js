app.factory('alertsManager', function() {
    return {
        alerts: {},
        
        addAlert: function(message, type) {
            this.alerts[type] = this.alerts[type] || [];
            this.alerts[type].push(message);
            console.log(this.alerts)
        },
        
        clearAlerts: function() {
            for(var x in this.alerts) {
            	delete this.alerts[x];
            }
        }
    };
});