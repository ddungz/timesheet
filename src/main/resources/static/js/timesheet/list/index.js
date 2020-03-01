const TSAPP = window.TSAPP || {};
import TimesheetList from './timesheet.js';

$(document).ready(function() {
	// 初期化
	const instance = new TimesheetList();
	instance.data.months = months;
	console.log('Departments', departments);
	instance.data.departments = departments;
	instance.init({data: instance});
	
	// 「対象月」変更イベント設定
	$('#TimesheetList').on('change', '#monthsDropdown', instance, function(event) {
		event.data.onMonthChange.apply(this, arguments);
	});
	
	// 「組織」変更イベント設定
	$('#TimesheetList').on('change', '#departmentsDropdown', instance, function(event) {
		event.data.onDepartmentChange.apply(this, arguments);
	});
	
	// 「グループ」変更イベント設定
	$('#TimesheetList').on('change', '#groupsDropdown', instance, function(event) {
		event.data.onGroupChange.apply(this, arguments);
	});
	
	// 「表示」ボタンイベント設定
	$('#TimesheetList').on('click', '#show', instance, function(event) {
		event.data.onShowClick.apply(this, arguments);
	});

	// 「PDF」ボタンイベント設定
	$('#TimesheetList').on('click', '#pdf', instance, function(event) {
		
	});

	// 「一括表示」ボタンイベント設定
	$('#TimesheetList').on('click', '#timesheetListTable-showAll', instance, function(event) {
	    event.data.onBulkShowClick.apply(this, arguments);
	});

	$('#TimesheetList').on('click', 'tbody tr button', instance, function(event) {
	    event.data.onShowScheduleDetailsClick.apply(this, arguments);
	});

});
