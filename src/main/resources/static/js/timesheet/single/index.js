const TSAPP = window.TSAPP || {};
import TimesheetSingle from './timesheet.js';

$(document).ready(function() {
	// 初期化
	const instance = new TimesheetSingle();
	instance.data.months = months;
	instance.init({data: instance});

	// 「対象月」変更イベント設定
	$('#TimesheetSingle').on('change', '#monthsDropdown', instance, function(event) {
		event.data.onMonthChange.apply(this, arguments);
	});

	// 「表示」ボタンイベント設定
	$('#TimesheetSingle').on('click', '#show', instance, function(event) {
		event.data.onShowClick.apply(this, arguments);
	});

	// 「PDF」ボタンイベント設定
	$('#TimesheetSingle').on('click', '#pdf', instance, function(event) {

	});

});
