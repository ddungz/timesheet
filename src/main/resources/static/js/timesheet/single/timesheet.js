const TSAPP = window.TSAPP || {};

export default class TimesheetList {
    constructor(options) {
        this.name = 'TimesheetList';
        this.options = options || {};
        let baseAPI = TSAPP._baseAPI;
        this.api = {
            show: baseAPI + '/timesheets/show',
            export: baseAPI + '/timesheets/export',
        };
        this.url = {
            timesheetSingle: '/timesheets'
        };
        this.data = {
            customers: [],
            months: [],
            departments: [],
            timesheets: [],
            month: null,
            departmentCode: null,
            groupCode: null,
            sessionData: {},

            searchCondition: {
                month: null,
                departmentCode: "",
                groupCode: "",
                selfConfirmation: "",
                managerApproval: "",
                generalApproval: "",
                assistantApproval: "",
            },

            table: {
                ref: null,
                id: 'timesheetListTable',
                pageLength: 20,
                widths: {
                    show: 'w-7',
                    departmentName: 'w-10',
                    groupName: 'w-10',
                    userFullName: 'w-8',
                    userCode: 'w-5',
                    month: 'w-5',
                    totalDeviation: 'w-3',
                    totalMissedLog: 'w-3',
                    totalLeave: 'w-3',
                    selfConfirmation: 'w-8',
                    managerApproval: 'w-8',
                    totalCorrectionPayment: 'w-4',
                    totalCorrectionHoliday: 'w-4',
                    totalCorrectionOther: 'w-4',
                    assistantApproval: 'w-8',
                    generalApproval: 'w-8'
                },
                tdAligns: {
                    show: 'text-center',
                },
                sorting: {
                    show: false,
                    departmentName: false,
                    groupName: false,
                    userFullName: false,
                    userCode: false,
                    month: false,
                    totalDeviation: false,
                    totalMissedLog: false,
                    totalLeave: false,
                    selfConfirmation: false,
                    managerApproval: false,
                    totalCorrectionPayment: false,
                    totalCorrectionHoliday: false,
                    totalCorrectionOther: false,
                    assistantApproval: false,
                    generalApproval: false
                },
                sortingOrders: [
//                    [3, 'asc']
                ],
                filters: {
                    reConfirmation: {
                        columns: [6, 7, 8],
                        filterBy: '_dataTableFilterByNumber',
                        filterTexts: ['乖離あり', 'ログなし', '勤務外'],
                    },
                    selfConfirmation: {
                        columns: [9],
                        filterBy: '_dataTableFilterByText',
                        filterTexts: ['未実施', '待機', '済'],
                    },
                    managerApproval: {
                        columns: [10],
                        filterBy: '_dataTableFilterByText',
                        filterTexts: ['未実施', '待機', '済'],
                    },
                    correctionConfirmation: {
                        columns: [11,12,13],
                        filterBy: '_dataTableFilterByText',
                        filterTexts: ['追給返納', '年休返還', 'その他'],
                    },
                    assistantApproval: {
                        columns: [14],
                        filterBy: '_dataTableFilterByText',
                        filterTexts: ['未実施', '待機', '済'],
                    },
                    generalApproval: {
                        columns: [15],
                        filterBy: '_dataTableFilterByText',
                        filterTexts: ['未実施', '待機', '済'],
                    }
                },
                locales: {
                    ja: {
                        filterTexts: {
                            reConfirmation: ['乖離あり', 'ログなし', '勤務外'],
                            selfConfirmation: ['未実施', '待機', '済'],
                            managerApproval: ['未実施', '待機', '済'],
                            correctionConfirmation: ['追給返納', '年休返還', 'その他'],
                            assistantApproval: ['未実施', '待機', '済'],
                            generalApproval: ['未実施', '待機', '済'],
                        },
                        titles: {
                            show: '<button id="timesheetListTable-showAll" class="btn btn-primary ml-3">一括表示</button>',
                            departmentName: '組織',
                            groupName: 'グループ',
                            userFullName: '氏名',
                            userCode: 'コード',
                            month: '対象月',
                            totalDeviation: '乖離あり',
                            totalMissedLog: 'ログなし',
                            totalLeave: '勤務外',
                            selfConfirmation: '本人確認<div id="timesheetListTable-selfConfirmation" class="form-inline justify-content-center"></div>',
                            managerApproval: '管理職承認<div id="timesheetListTable-managerApproval" class="form-inline justify-content-center"></div>',
                            totalCorrectionPayment: '追給返納',
                            totalCorrectionHoliday: '年休返還',
                            totalCorrectionOther: 'その他',
                            assistantApproval: '人事担当補正<div id="timesheetListTable-assistantApproval" class="form-inline justify-content-center"></div>',
                            generalApproval: '総括担当補正<div id="timesheetListTable-generalApproval" class="form-inline justify-content-center"></div>'
                        },
                    },
                    en: {
                        filterTexts: {
                            confirmation: ['Not yet', 'Waiting', 'Done'],
                            reConfirmation: ['Has deviated', 'Has missed log', 'Has leaved out'],
                            selfConfirmation: ['Not yet', 'Waiting', 'Done'],
                            managerApproval: ['Not yet', 'Waiting', 'Done'],
                            correctionConfirmation: ['Correction payment', 'Correction holiday', 'Other'],
                            assistantApproval: ['Not yet', 'Waiting', 'Done'],
                            generalApproval: ['Not yet', 'Waiting', 'Done'],
                        },
                        titles: {
                            show: '<button id="timesheetListTable-showAll" class="btn btn-primary ml-3">Display All</button>',
                            departmentName: 'Department',
                            groupName: 'Group',
                            userFullName: 'Full Name',
                            userCode: 'Code',
                            month: 'Month',
                            totalDeviation: 'Deviated',
                            totalMissedLog: 'Missed Log',
                            totalLeave: 'Leaved',
                            selfConfirmation: 'Confirmed<div id="timesheetListTable-selfConfirmation" class="form-inline justify-content-center"></div>',
                            managerApproval: 'Manager Approval<div id="timesheetListTable-managerApproval" class="form-inline justify-content-center"></div>',
                            totalCorrectionPayment: 'Payment',
                            totalCorrectionHoliday: 'Holiday',
                            totalCorrectionOther: 'Other',
                            assistantApproval: 'HR Approval<div id="timesheetListTable-assistantApproval" class="form-inline justify-content-center"></div>',
                            generalApproval: 'General Approval<div id="timesheetListTable-generalApproval" class="form-inline justify-content-center"></div>'
                        },
                    }
                }
            },
        }

        TSAPP.component = this
    };

    init(event) {
        console.log('onMonthChange()');
        const instance = event.data;
        instance.onMonthChange(event);
        instance._initDataTable(event);

        instance._getSessionInfo(event);
        instance._removeSessionInfo(event, 'timesheetSingle');
        instance._setSessionInfo(event, 'timesheetList');
    };

    _getSessionInfo(event) {
        console.log('_getSessionInfo()');

        const instance = event.data;
        const storage = TSAPP.store.sessionStorage;

        const month = storage.getItem('timesheetSingle.month');
        const groupCode = storage.getItem('timesheetSingle.groupCode');
        const departmentCode = storage.getItem('timesheetSingle.departmentCode');
        console.log(month, groupCode, departmentCode);

        instance.data.sessionData = {
            month: month,
            groupCode: groupCode,
            departmentCode: departmentCode,
        }
    }

    _removeSessionInfo(event, componentName) {
        console.log('_clearSessionInfo()');

        const instance = event.data;
        const storage = TSAPP.store.sessionStorage;

        Object.keys(instance.data.sessionData).forEach(function(key) {
            storage.removeItem(componentName + '.' + key);
        });
    }

    _setSessionInfo(event, componentName) {
        console.log('_setSessionInfo()');

        const instance = event.data;
        const storage = TSAPP.store.sessionStorage;

        Object.keys(instance.data.sessionData).forEach(function(key) {
            storage.setItem(componentName + '.' + key, instance.data.sessionData[key]);
        });
    }

    _initDataTable(event) {
        console.log('_initDataTable()');
        const instance = event.data;
        instance._render(event);
    };

    onMonthChange(event) {
        /**
         * 対象月変更処理
         */
        console.log('onMonthChange()');

        const instance = event.data;
        var month = instance._getDropdownValueById('monthsDropdown');
        instance.data.month = month;
    };

    onDepartmentChange(event) {
        /**
         * 組織変更処理
         */
        console.log('onDepartmentChange()');

        const instance = event.data;
        var departmentCode = instance._getDropdownValueById('departmentsDropdown');
        instance.data.departmentCode = departmentCode;
        instance.data.groupCode = "";

        let department = instance.data.departments.find(item => item.code == departmentCode);
        let groups = department && department.groups || {};
        instance._renderGroupsDropdown(event, groups);
        console.log(instance.data);
    };

    onGroupChange(event) {
        /**
         * グループ変更処理
         */
        console.log('onGroupChange()');

        const instance = event.data;
        var groupCode = instance._getDropdownValueById('groupsDropdown');
        instance.data.groupCode = groupCode;
        console.log(groupCode);
    };

    _renderGroupsDropdown(event, groups) {
        /**
         * 組織によりグループ選択肢生成
         */
        console.log('_renderGroupsDropdown()');

        var options = '<option value="" selected="selected"></option>';
        if(groups && groups.length > 0) {
            $.each(groups, function(index, item) {
                options += '<option value="' + item.code + '">' + item.name + '</option>';
            });
        }
        $('#groupsDropdown').empty().append($(options));
    }

    onShowClick(event) {
        /**
         * グループ変更処理
         */
        console.log('onShowClick()');
        const instance = event.data;
        instance._show(event);
    };

    onBulkShowClick(event) {
        console.log('onBulkShowClick()');

        const instance = event.data;

        // Clear current selected department and group
        instance._resetDepartmentAndGroup(event);

        // Get checked input
        var inputs = instance._getSelectedRows(event);
        $.each(inputs, function(val) {
            var row = $(this).closest('tr')[0];
            console.log(row);
        });
    };

    onShowScheduleDetailsClick(event) {
        console.log('onShowScheduleDetailsClick()');

        const instance = event.data;

        var rowData = instance._getClickedRowData(event);

        if(!rowData || !rowData.userId) {
            // view.fireErrorDialog();
            return;
        }

        instance._goToTimesheetSingle(event);
    }

    _goToTimesheetSingle(event) {
        const view = TSAPP.view;
        const localStorage = TSAPP.store.localStorage;

        const instance = event.data;

        const table = instance.data.table.ref;

        localStorage.setItem('timesheetSingle.month', instance.data.month);
        localStorage.setItem('timesheetSingle.departmentCode', instance.data.departmentCode);
        localStorage.setItem('timesheetSingle.groupCode', instance.data.groupCode);
        // localStorage.setItem('timesheetSingle.filtering', table.columns().search());

        const rowData = instance._getClickedRowData(event);
        const redirectURI = instance.url.timesheetSingle + '/' + rowData.userId;

        view.redirect(redirectURI);
    }

    _getFilteringValues() {
        var filters = {};

        return filters;
    }

    _resetDepartmentAndGroup(event) {
        console.log('_resetDepartmentAndGroup()');

        const instance = event.data;
        $('#departmentsDropdown').prop('selectedIndex', 0);
        instance.onDepartmentChange($.extend(true, event, {target: $('#departmentsDropdown')}));
        instance.onGroupChange($.extend(true, event, {target: $('#groupsDropdown')}));
    }

    _show(event) {
        console.log('_show()');

        const instance = event.data;
        const rest = TSAPP.rest;

        var json = {
            month: instance.data.month
        };
        if(instance.data.departmentCode) {
            json.departmentCode = instance.data.departmentCode;
        }
        if(instance.data.groupCode) {
            json.groupCode = instance.data.groupCode;
        }

        rest.get(instance.api.show, json, {
            successHandler: function(data, status, xhr) {
                console.log(data);
                if(data && data.success) {
                    instance.data.users = data.data;
                    instance._render({data: instance});
                }
            },
            errorHandler: function(data, status, xhr) {
                console.log('error data', data);
            },
            options: {
                async: true,
                isLoading: true,
            }
        });
    }

    _render(event) {
        console.log('_render()');

        const instance = event.data;

        var aaData = instance._getDataTableData(event);
        const PAGE_LENGTH = instance.data.table.pageLength;

        if(instance.data.table.ref) {
            instance.data.table.ref.clear();
            instance.data.table.ref.rows.add(aaData);
            instance.data.table.ref.draw();
        }
        else {
            var tableId = instance.data.table.id;
            var config = TSAPP.view.dataTableConfig(TSAPP.locale.currentLocale);
            var orders = instance.data.table.sortingOrders;
            var aoColumns = instance._getDataTableColumns(event, aaData);
            var _initComplete = instance._dataTableInitComplete;
            var _drawCallback = instance._dataTableDrawCallback;

            config = $.extend(config, {
                data: aaData,
                columns: aoColumns,
                bFilter: true, // dropdown filter
                searching: true, // input text search
                ordering: true,
                order: orders,
                pageLength: PAGE_LENGTH,
                initComplete: _initComplete,
                drawCallback: _drawCallback,
                instance: instance,
            });
            instance.data.table.ref = $('#'+tableId).DataTable(config);
        }
    };

    _getDataTableData(event) {
        console.log('_getDataTableData()');

        var instance = event.data;
        const util = TSAPP.util;
        const currentLocale = TSAPP.locale.currentLocale;
        var departments = instance.data.departments;
        var users = instance.data.users;
        var data = [];

        $.each(users, function(index, user) {
            var rowData = {};
            var month = instance.data.month.replace("/", "-");
            var schedule = user.schedules ? user.schedules.find(item => item.month == month) : null;

            var scheduleApprovals = schedule ? schedule.approvals : [];
            var latestApprovedLevel = schedule ? schedule.approvedLevel : -1;
            var approval = scheduleApprovals.find(sa => sa.approvalLevel == latestApprovedLevel);

            var conAndAppTexts = instance._getConfirmationAndApprovalStatus(schedule);

            rowData.userId = user.id;
            rowData.month = instance.data.month;
            rowData.departmentCode = instance.data.departmentCode;
            rowData.groupCode = instance.data.groupCode;
            rowData.schedule = schedule;

            rowData.show = "";
            rowData.departmentName = instance._getDepartmentName(event, user.departmentCode);
            rowData.groupName = user.group ? user.group.name : '';
            rowData.userFullName = user.firstname + ' ' + user.lastname;
            rowData.userCode = user.userCode;
            rowData.month = instance.data.month;
            rowData.totalDeviation = (approval && approval.totalDeviation ? approval.totalDeviation : '-');
            rowData.totalMissedLog = (approval && approval.totalMissedLog ? approval.totalMissedLog : '-');
            rowData.totalLeave = (approval && approval.totalLeave ? approval.totalLeave : '-');
            rowData.selfConfirmation = conAndAppTexts['selfConfirmation'];
            rowData.managerApproval = conAndAppTexts['managerApproval'];
            rowData.totalCorrectionPayment = (approval && approval.totalCorrectionPayment ? approval.totalCorrectionPayment : '');
            rowData.totalCorrectionHoliday = (approval && approval.totalCorrectionHoliday ? approval.totalCorrectionHoliday : '');
            rowData.totalCorrectionOther = (approval && approval.totalCorrectionOther ? approval.totalCorrectionOther : '');
            rowData.assistantApproval = conAndAppTexts['assistantApproval'];
            rowData.generalApproval = conAndAppTexts['generalApproval'];

            data.push(rowData);
        });

        console.log('Data', data);
        return data;
    }

    _getDepartmentName(event, departmentCode) {
        const instance = event.data;
        const departments = instance.data.departments;
        const department = departments.find(d => d.code == departmentCode);
        return department ? department.name : "";
    }

    _getConfirmationAndApprovalStatus(schedule) {
        const _ = TSAPP.locale._;
        const TEXT_NOT_YET = 'Not yet';
        const TEXT_WAITING = 'Waiting';
        const TEXT_DONE = 'Done';
        const HAS_DEVIATION = '乖離あり';
        const HAS_MISSED_LOG = 'ログなし';
        const HAS_LEAVED_OUT = '勤務外';
        const ASSISTANT_APPROVAL = '01';
        const GENERAL_APPROVAL = '02';
        const MANAGER_APPROVAL = '03';
        const CONFIRM_NOT_YET = '01';
        const CONFIRM_WAITING = '02';
        const CONFIRM_DONE = '03';
        const APPROVAL_NOT_YET = '01';
        const APPROVAL_WAITING = '02';
        const APPROVAL_DONE = '03';

        // 本人確認
        var confirmationText = '-';

        // 承認種別
        var approvalTexts = {
            approvalText_01: '-', // 人事
            approvalText_02: '-', // 総括
            approvalText_03: '-' // 管理
        }

        if(schedule) {
            if(schedule.confirmedStatus == CONFIRM_NOT_YET) {
                confirmationText = _(TEXT_NOT_YET);
            } else if(schedule.confirmedStatus == CONFIRM_WAITING) {
                confirmationText = _(TEXT_WAITING);
            } else if(schedule.confirmedStatus == CONFIRM_DONE) {
                confirmationText = _(TEXT_DONE) + '（' + schedule.confirmedAt + '）';
            }

            $.each([ASSISTANT_APPROVAL, GENERAL_APPROVAL, MANAGER_APPROVAL], function(i, level) {
                var scheduleApprovals = schedule.approvals ? schedule.approvals : [];
                var approval = scheduleApprovals.find(item => item.approvalLevel == level);

                let approvalText = '-';
                if(!approval) {
                } else if(approval.approvalStatus == APPROVAL_NOT_YET) {
                    approvalText = _(TEXT_NOT_YET);
                } else if(approval.approvalStatus == APPROVAL_WAITING) {
                    approvalText = _(TEXT_WAITING);
                } else if(approval.approvalStatus == APPROVAL_DONE) {
                    approvalText = _(TEXT_DONE) + '（' + approval.approvedAt + '）';
                }

                approvalTexts['approvalText_' + level] = confirmationText;
            });
        }

        return {
            selfConfirmation: confirmationText,
            assistantApproval: approvalTexts['approvalText_01'],
            generalApproval: approvalTexts['approvalText_02'],
            managerApproval: approvalTexts['approvalText_03']
        };
    }

    _getDataTableColumns(event, aaData) {
        console.log('_getDataTableColumns()');

        const instance = event.data;
        var aoColumns = [];

        const sorting = instance.data.table.sorting;
        const widths = instance.data.table.widths;
        const renders = instance._getDataTableColumnRenders(event, aaData);
        const titles = instance._getDataTableColumnTitles(event);
        const columnNames = Object.keys(titles);
        const titleTexts = Object.values(titles);

        $.each(columnNames, function(index, columnName) {
            var column = {
                class: widths[columnName] ? widths[columnName] : '',
                sortable: sorting[columnName] ? sorting[columnName] : false,
                data: columnName,
                title: titleTexts[index],
                render: renders[columnName],
                createdCell: function(td, cellData, rowData, row, col) {
                    $(td).removeClass(columnName).addClass(columnName);
                }
            };

            aoColumns.push(column);
        });

        console.log('Columns', aoColumns);
        return aoColumns;
    }

    _getDataTableColumnRenders(event, aaData) {
        console.log('_getDataTableColumnRenders()');

        const instance = event.data;
        const titles = instance._getDataTableColumnTitles(event);
        const columnNames = Object.keys(titles);
        var renders = {};

        $.each(columnNames, function(index, columnName) {
            renders[columnName] = function(data, type, row) {
                return $('<td></td>', {
                    'text': data
                }).prop('innerHTML');
            }
        });

        renders['show'] = function(data, type, row) {
            return '<td>' +
                '<div class="custom-control custom-checkbox">' +
                '<input type="checkbox" class="custom-control-input" name="show-id-' + row.userId + '" id="show-id-' + row.userId + '" data-user-id="' + row.userId + '">' +
                '<label class="custom-control-label" for="show-id-' + row.userId + '"></label>' +
                '<button type="button" class="btn btn-sm btn-outline-primary showDetails">詳細</button>' +
                '</div>' +
                '</td>';
        }

        renders['userFullName'] = function(data, type, row) {
            return '<a href="/timesheets/' + row.userId +  '">' + data + '</a>';
        }

        return renders;
    }

    _getDataTableColumnTitles(event) {
        console.log('_getDataTableColumnTitles()');

        const instance = event.data;
        var currentLocale = TSAPP.locale.currentLocale;
        const locales = instance.data.table.locales;
        return locales[currentLocale].titles;
    }

    _dataTableInitComplete(config) {
        console.log('_dataTableInitComplete()');

        const instance = config.oInit.instance;
        const tableId = instance.data.table.id;
        const filters = instance.data.table.filters;
        const filterColumnNames = Object.keys(filters);

        const currentLocale = TSAPP.locale.currentLocale;
        const filterColumnTexts = instance.data.table.locales[currentLocale].filterTexts;

        var dtApi = this.api();
        $.each(filterColumnNames, function(ind, columnName) {
            var filter = filters[columnName];
            var filterTexts = filterColumnTexts[columnName];

            var container = document.getElementById(tableId + "-" + columnName);
            var node = $('<select id="' + columnName + 'Dropdown" class="custom-select custom-select-sm"><option value=""></option></select>')
                .appendTo( $(container) );
            instance._appendOptionsAndBindFilterAction(instance, dtApi, columnName, node, filter, filterTexts);
        });
    }

    _appendOptionsAndBindFilterAction(instance, dtApi, columnName, node, filter, filterTexts) {
        var filterBy = filter.filterBy;
        var filterColumns = filter.columns;

        $.each(filterTexts, function(ind3, text) {
            var opt = '';
            if(filterTexts.length != filterColumns.length) {
                opt = '<option value="' + filterColumns[0] + '">' + text + '</option>'
            } else {
                opt = '<option value="' + filterColumns[ind3] + '">' + text + '</option>'
            }
            $(node).append( opt );
        });

        $(node).on( 'change', function () {
            var colIdx = $.fn.dataTable.util.escapeRegex( $(this).val() );
            instance._releaseLastFilter(dtApi, colIdx, filterColumns);
            instance._doDataTableFilter(instance, dtApi, columnName, colIdx, filterColumns, filterBy);
        });
    }

    _releaseLastFilter(dtApi, colIdx, filterColumns) {
        $.each(filterColumns, function(ind2, val2) {
            let column = dtApi.columns(val2).search("");
            if(!colIdx) {
                column.draw();
            }
        });
    }

    _doDataTableFilter(instance, dtApi, columnName, colIdx, filterColumns, filterBy) {
        if(instance[filterBy] && typeof instance[filterBy] === 'function') {
            instance[filterBy]( {data: instance}, dtApi, columnName, colIdx, filterColumns );
        }
    }

    _dataTableFilterByNumber(event, dtApi, columnName, colIdx, colIndexes) {
        if(colIdx) {
            dtApi.columns(colIdx).search( '^\\d+$', true, false ).draw();
        }
    }

    _dataTableFilterByText(event, dtApi, columnName, colIdx, colIndexes) {
        if(colIdx) {
            const instance = event.data;
            const tableId = instance.data.table.id;
            var select = $('#' + tableId + '-' + columnName).find('select')[0];
            var txt = select.options[select.selectedIndex].text;
            dtApi.columns(colIdx).search( '^' + txt, true, false ).draw();
        }
    }

    _dataTableDrawCallback(config) {
        console.log('_dataTableDrawCallback()');

        const instance = config.oInit.instance;
        var tableId = instance.data.table.id;
        var table = $('#' + tableId);

        var $wrapper = $(table).closest('.dataTables_wrapper');
        $wrapper.find('#' + tableId + '_filter').css({display: 'none'});
        $wrapper.find('#' + tableId + '_paginate').removeClass('dataTables_paginate').addClass("pagination pagination-sm justify-content-end mr-3");

        const tdAligns = instance.data.table.tdAligns;
        var $trs = table.find('> tbody > tr');
        $.each($trs, function(index) {
            var $tr = $(this);
            $.each(tdAligns, function(key, tdAlign) {
                var $td = $tr.find('td:eq(0)');
                if($td.length && $td.hasClass('dataTables_empty')) {
                    $td.removeClass('text-center').addClass('text-center');
                } else {
                    $td = $tr.find('> td.' + key);
                    $td.removeClass(tdAlign).addClass(tdAlign);
                }
            });
        });
    }

    _getClickedRowData(event) {
        const instance = event.data;

        var table = instance.data.table.ref;

        var row = instance._getClickedRow(event);

        var rowData = table.row(row).data();
        console.log(rowData);

        return rowData;
    }

    _getClickedRow(event) {
        return $(event.target).closest('tr');
    }

    _getSelectedRows(event) {
        const instance = event.data;

        var tableId = instance.data.table.id;
        var inputs = $('#' + tableId).find('input[type=checkbox]:checked');
        return inputs;
    }

    _getDropdownValueById(id) {
        var el = document.getElementById(id);
        return el.options[el.selectedIndex].value;
    }
}
