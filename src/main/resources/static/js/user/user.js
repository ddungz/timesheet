const TSAPP = window.TSAPP || {};

export default class User {
    constructor(options) {
        this.name = 'User';
        this.options = options || {};
        let baseAPI = TSAPP._baseAPI;
        this.api = {
            search: baseAPI + '/users',
            get: baseAPI + '/users/get',
            add: baseAPI + '/users/add',
            update: baseAPI + '/users/update',
            delete: baseAPI + 'users/delete'
        }
        this.data = {
            customers: [],
            departments: []
        }
    }
    
    onDepartmentChange(event) {
    	console.log('User.onDepartmentChange() start');
    };
    
    initDataTable(event) {
    	$('#example').DataTable( {
            initComplete: function () {
                this.api().columns().every( function () {
                    var column = this;
                    var select = $('<select><option value=""></option></select>')
                        .appendTo( $(column.footer()).empty() )
                        .on( 'change', function () {
                            var val = $.fn.dataTable.util.escapeRegex(
                                $(this).val()
                            );

                            column
                                .search( val ? '^'+val+'$' : '', true, false )
                                .draw();
                        } );
     
                    column.data().unique().sort().each( function ( d, j ) {
                        select.append( '<option value="'+d+'">'+d+'</option>' )
                    } );
                } );
            }
        } );
    };

    search(event) {
        console.log('User.search() start');
        const userInstance = event.data;
        
        let self = this;
        let rest = TSAPP.rest;
        let json = {};
        let url = userInstance.api.search;

        rest.post(url, json, {
            successHandler: function(response, status, xhr) {
                console.log(response);
                if(response.status >= 200 && response.status < 300) {
                	userInstance.dataList = response.data;
                	userInstance.render({data: userInstance});
                } else {
                    console.log('User.search() response error ' + status);
                }
            },
            ajaxOptions: {
                aync: false
            }
        });
    };

    render(event) {
        console.log('User.render() start');
        const userInstance = event.data;
        if(!userInstance.dataList || userInstance.dataList.length == 0) {
            return;
        }
        
        var trs = "";
        $.each(userInstance.dataList, function(index, user) {
            trs += "<tr>" +
            "<td>" + user.id + "</td>" +
            "<td>" + user.username + "</td>" +
            "<td>" + user.email + "</td>" +
            "</td>";
        });

        $('#usersTable-tBody').html(trs);
        $('#usersTable').css('display', '');
    };
}
