DROP TABLE IF EXISTS tbl_t_users;
CREATE TABLE tbl_t_users (
	id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "ユーザID",
	username VARCHAR(32) UNIQUE NOT NULL COMMENT "ユーザ名",
	email VARCHAR(50) UNIQUE NOT NULL COMMENT "メール",
	password VARCHAR(255) NOT NULL COMMENT "パワード",
	firstname VARCHAR(32) COMMENT "名",
	lastname VARCHAR(32) COMMENT "姓",
    user_code VARCHAR(8) NOT NULL COMMENT "氏名コード",
	department_code VARCHAR(6) COMMENT "組織",
	group_code VARCHAR(6) COMMENT "グループ",
    excluded_type VARCHAR(4) COMMENT "除外者種別",

	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "登録日",
	created_by varchar(32) NOT NULL DEFAULT "system" COMMENT "登録者",
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新日",
	updated_by varchar(32) DEFAULT NULL COMMENT "更新者",
    deleted_at datetime DEFAULT NULL COMMENT "削除日",
	deleted_by varchar(32) DEFAULT NULL COMMENT "削除者"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE INDEX idx_user_fullname ON tbl_t_users (firstname, lastname);


DROP TABLE IF EXISTS tbl_t_departments;
CREATE TABLE tbl_t_departments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "ID",
	code VARCHAR(6) NOT NULL COMMENT "組織コード",
    name VARCHAR(128) NOT NULL COMMENT "組織名",

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "登録日",
	created_by varchar(32) NOT NULL DEFAULT "system" COMMENT "登録者",
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新日",
	updated_by varchar(32) DEFAULT NULL COMMENT "更新者",
    deleted_at datetime DEFAULT NULL COMMENT "削除日",
	deleted_by varchar(32) DEFAULT NULL COMMENT "削除者"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE INDEX idx_department_code ON tbl_t_departments (code);

DROP TABLE IF EXISTS tbl_t_groups;
CREATE TABLE tbl_t_groups (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "ID",
	department_id VARCHAR(6) NOT NULL COMMENT "組織ID",
	code VARCHAR(6) NOT NULL COMMENT "グループコード",
    name VARCHAR(128) NOT NULL COMMENT "グループ名",

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "登録日",
	created_by varchar(32) NOT NULL DEFAULT "system" COMMENT "登録者",
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新日",
	updated_by varchar(32) DEFAULT NULL COMMENT "更新者",
    deleted_at datetime DEFAULT NULL COMMENT "削除日",
	deleted_by varchar(32) DEFAULT NULL COMMENT "削除者"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE INDEX idx_group_code ON tbl_t_departments (code);


DROP TABLE IF EXISTS tbl_t_excluded_types;
CREATE TABLE tbl_t_excluded_types (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "ID",
	type VARCHAR(4) UNIQUE NOT NULL COMMENT "除外者タイプ",
    name VARCHAR(128) NOT NULL COMMENT "除外者タイプ名",

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "登録日",
	created_by varchar(32) NOT NULL DEFAULT "system" COMMENT "登録者",
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新日",
	updated_by varchar(32) DEFAULT NULL COMMENT "更新者",
    deleted_at datetime DEFAULT NULL COMMENT "削除日",
	deleted_by varchar(32) DEFAULT NULL COMMENT "削除者"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS tbl_t_roles;
CREATE TABLE tbl_t_roles (
	id BIGINT PRIMARY KEY COMMENT "ロールコード",
	name VARCHAR(32) UNIQUE NOT NULL COMMENT "ロール名",
    category VARCHAR(2) NOT NULL COMMENT "ロール種類",
    category_name VARCHAR(20) COMMENT "ロール種類名",
    title VARCHAR(20) COMMENT "担当",
    display_order INTEGER NOT NULL COMMENT "表示準",

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "登録日",
	created_by varchar(32) NOT NULL DEFAULT "system" COMMENT "登録者",
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新日",
	updated_by varchar(32) DEFAULT NULL COMMENT "更新者",
    deleted_at datetime DEFAULT NULL COMMENT "削除日",
	deleted_by varchar(32) DEFAULT NULL COMMENT "削除者"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS tbl_t_user_roles;
CREATE TABLE tbl_t_user_roles (
	id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "ID",
	user_id BIGINT NOT NULL COMMENT "ユーザID",
	role_id BIGINT NOT NULL COMMENT "ロール名",

	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "登録日",
	created_by varchar(32) NOT NULL DEFAULT "system" COMMENT "登録者",
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新日",
	updated_by varchar(32) DEFAULT NULL COMMENT "更新者",
    deleted_at datetime DEFAULT NULL COMMENT "削除日",
	deleted_by varchar(32) DEFAULT NULL COMMENT "削除者"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE INDEX idx_user_role_user_id ON tbl_t_user_roles(user_id);
CREATE INDEX idx_user_role_role_name ON tbl_t_user_roles(role_id);


DROP TABLE IF EXISTS tbl_t_projects;
CREATE TABLE tbl_t_projects (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "ID",
	code VARCHAR(10) UNIQUE NOT NULL COMMENT "プロジェクト番号",
	name VARCHAR(128) COMMENT "プロジェクト名",
	status VARCHAR(2) NOT NULL DEFAULT "01" COMMENT "プロジェクトステータス",
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "登録日",
	created_by varchar(32) NOT NULL DEFAULT "system" COMMENT "登録者",
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新日",
	updated_by varchar(32) DEFAULT NULL COMMENT "更新者",
    deleted_at datetime DEFAULT NULL COMMENT "削除日",
	deleted_by varchar(32) DEFAULT NULL COMMENT "削除者"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE INDEX idx_project_code ON tbl_t_projects(code);

DROP TABLE IF EXISTS tbl_t_user_projects;
CREATE TABLE tbl_t_user_projects (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "ID",
	user_id BIGINT NOT NULL COMMENT "ユーザID",
	project_id BIGINT NOT NULL COMMENT "プロジェクト番号",

	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "登録日",
	created_by varchar(32) NOT NULL DEFAULT "system" COMMENT "登録者",
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新日",
	updated_by varchar(32) DEFAULT NULL COMMENT "更新者",
    deleted_at datetime DEFAULT NULL COMMENT "削除日",
	deleted_by varchar(32) DEFAULT NULL COMMENT "削除者"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
CREATE INDEX idx_user_project_user_id ON tbl_t_user_projects(user_id);
CREATE INDEX idx_user_project_project_id ON tbl_t_user_projects(project_id);


DROP TABLE IF EXISTS tbl_t_schedules;
CREATE TABLE tbl_t_schedules (
	id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "ID",
	user_id BIGINT NOT NULL COMMENT "ユーザID1",
	month VARCHAR(7) NOT NULL COMMENT "対象月",
	confirmed_status VARCHAR(2) NOT NULL DEFAULT "01" COMMENT "本人の確認ステータス",
	confirmed_at VARCHAR(10) COMMENT "確認日",
	approved_level VARCHAR(2) COMMENT "Current Approval Level",

	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "登録日",
	created_by varchar(32) NOT NULL DEFAULT "system" COMMENT "登録者",
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新日",
	updated_by varchar(32) DEFAULT NULL COMMENT "更新者",
    deleted_at datetime DEFAULT NULL COMMENT "削除日",
	deleted_by varchar(32) DEFAULT NULL COMMENT "削除者"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS tbl_t_schedule_approvals;
CREATE TABLE tbl_t_schedule_approvals (
	id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "ID",
	schedule_id BIGINT NOT NULL COMMENT "対象月ID",
	approval_status VARCHAR(20) COMMENT "承認ステータス",
	approval_level VARCHAR(2) NOT NULL DEFAULT "01" COMMENT "承認種別",
    approved_by VARCHAR(32) NOT NULL COMMENT "承認者の名",
    approved_at VARCHAR(10) COMMENT "時間補正日",
    total_deviation INTEGER COMMENT "乖離有り数",
    total_missed_log INTEGER COMMENT "ログ無し数",
    total_leave INTEGER COMMENT "勤務外数",
    -- schedule corrections
    total_correction_payment INTEGER COMMENT "補正種別追納返納",
    total_correction_holiday INTEGER COMMENT "補正種別年休返還",
    total_correction_other INTEGER COMMENT "補正種別その他",

	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "登録日",
	created_by varchar(32) NOT NULL DEFAULT "system" COMMENT "登録者",
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新日",
	updated_by varchar(32) DEFAULT NULL COMMENT "更新者",
    deleted_at datetime DEFAULT NULL COMMENT "削除日",
	deleted_by varchar(32) DEFAULT NULL COMMENT "削除者"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


--DROP TABLE IF EXISTS tbl_t_schedule_corrections;
--CREATE TABLE tbl_t_schedule_corrections (
--	id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "ID",
--	schedule_approval_id BIGINT NOT NULL COMMENT "対象月ID",
--	correction_type VARCHAR(2) NOT NULL COMMENT "補正種別",
--	total INTEGER NOT NULL DEFAULT 0 COMMENT "補正種別数",
--
--	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "登録日",
--	created_by varchar(32) NOT NULL DEFAULT "system" COMMENT "登録者",
--	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新日",
--	updated_by varchar(32) DEFAULT NULL COMMENT "更新者",
--    deleted_at datetime DEFAULT NULL COMMENT "削除日",
--	deleted_by varchar(32) DEFAULT NULL COMMENT "削除者"
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT="補正種別テーブル--01:追納返納;02:年休返還;03:その他";


DROP TABLE IF EXISTS tbl_t_timesheets;
CREATE TABLE tbl_t_timesheets (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "ID",
    history_id BIGINT COMMENT "レポート歴史ID",
    schedule_id BIGINT NOT NULL COMMENT "対象月ID",
    day VARCHAR(10) NOT NULL COMMENT "対象日",
    work_type VARCHAR(128) COMMENT "勤務形態",
    holiday VARCHAR(255) COMMENT "休暇",
    note VARCHAR(255) COMMENT "コメント",
    start_time VARCHAR(5) NOT NULL COMMENT "開始時刻",
    end_time VARCHAR(5) NOT NULL COMMENT "終了時刻",

    logged_type VARCHAR(5) COMMENT "ログ種別",
    logged_start_time VARCHAR(5) COMMENT "始業時刻",
    logged_end_time VARCHAR(5) COMMENT "終業時刻",
    logged_connection_time VARCHAR(8) COMMENT "接続時間",

    deviated_start_time VARCHAR(6) COMMENT "乖離時間始業前",
    deviated_end_time VARCHAR(6) COMMENT "乖離時間終業後",

    evaluated_start_time VARCHAR(50) COMMENT "判定始業時刻",
    evaluated_end_time VARCHAR(50) COMMENT "判定終業時刻",

    corrected_start_time VARCHAR(5) COMMENT "勤務票時間補正始業時刻",
    corrected_end_time VARCHAR(5) COMMENT "勤務票時間補正終業時刻",
    corrected_duration VARCHAR(5) COMMENT "勤務票時間補正実労働時間",
    deviated_duration VARCHAR(50) COMMENT "勤務票時間補正--時間",

    correction_note VARCHAR(255) COMMENT "勤務票時間補正コメント",
    correction_payment BOOLEAN COMMENT "補正種別追納返納",
    correction_holiday BOOLEAN COMMENT "補正種別年休返還",
    correction_other BOOLEAN COMMENT "補正種別その他",

    locked_flg BOOLEAN DEFAULT 0 COMMENT "承認中フラグ",
    locked_by VARCHAR(32) COMMENT "承認者",

	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "登録日",
	created_by varchar(32) NOT NULL DEFAULT "system" COMMENT "登録者",
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新日",
	updated_by varchar(32) DEFAULT NULL COMMENT "更新者",
    deleted_at datetime DEFAULT NULL COMMENT "削除日",
	deleted_by varchar(32) DEFAULT NULL COMMENT "削除者"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS tbl_t_timesheet_histories;
CREATE TABLE tbl_t_timesheet_histories (
	id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "ID",
	timesheet_id BIGINT NOT NULL COMMENT "レポートID",
	latest_timesheet_approval_id BIGINT COMMENT "最終承認ID",
	project_id BIGINT NOT NULL COMMENT "プロジェクトID",
	day VARCHAR(10) NOT NULL COMMENT "対象日",
	day_type VARCHAR(2) COMMENT "対象日種別",
	work_type VARCHAR(2) COMMENT "勤務形態",
	is_night_shift BOOLEAN DEFAULT 0 COMMENT "深夜出勤フラグ",
	is_overnight_work BOOLEAN DEFAULT 0 COMMENT "当日開業から翌日終業フラグ",
	start_time VARCHAR(5) NOT NULL COMMENT "開始時刻",
	end_time VARCHAR(5) NOT NULL COMMENT "終了時刻",
	duration VARCHAR(5) COMMENT "労働時間",
	note VARCHAR(255) COMMENT "コメント",

	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "登録日",
	created_by varchar(32) NOT NULL DEFAULT "system" COMMENT "登録者",
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新日",
	updated_by varchar(32) DEFAULT NULL COMMENT "更新者",
    deleted_at datetime DEFAULT NULL COMMENT "削除日",
	deleted_by varchar(32) DEFAULT NULL COMMENT "削除者"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS tbl_t_timesheet_leaves;
CREATE TABLE tbl_t_timesheet_leaves (
	id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "ID",
	timesheet_history_id BIGINT NOT NULL COMMENT "レポート歴史ID",
	start_time VARCHAR(5) COMMENT "開始時刻",
	end_time VARCHAR(5) COMMENT "終了時刻",
	work_on_rest_time BOOLEAN COMMENT "休憩に働いたフラグ",
	duration VARCHAR(5) COMMENT "休憩に働いた時間",
	note VARCHAR(256) COMMENT "コメント",
	
	corrected_start_time VARCHAR(5) COMMENT "開始時刻",
	corrected_end_time VARCHAR(5) COMMENT "終了時刻",
	corrected_work_on_rest_time BOOLEAN COMMENT "休憩に働いたフラグ",
	corrected_duration VARCHAR(5) COMMENT "休憩に働いた時間",
	corrected_with_note VARCHAR(256) COMMENT "コメント",
	
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "登録日",
	created_by varchar(32) NOT NULL DEFAULT "system" COMMENT "登録者",
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新日",
	updated_by varchar(32) DEFAULT NULL COMMENT "更新者",
    deleted_at datetime DEFAULT NULL COMMENT "削除日",
	deleted_by varchar(32) DEFAULT NULL COMMENT "削除者"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS tbl_t_timesheet_approvals;
CREATE TABLE tbl_t_timesheet_approvals (
	id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "ID",
	timesheet_history_id BIGINT NOT NULL COMMENT "レポートID",
	approval_status VARCHAR(2) COMMENT "承認ステータス",
	approval_level VARCHAR(2) NOT NULL DEFAULT "01" COMMENT "承認種別",
    approved_by VARCHAR(32) NOT NULL COMMENT "承認者の名",
    approved_at VARCHAR(10) COMMENT "時間補正日",
	corrected_project_id BIGINT NOT NULL COMMENT "プロジェクトID",
	corrected_day_type VARCHAR(2) COMMENT "対象日種別",
	corrected_work_type VARCHAR(2) COMMENT "勤務形態",
	corrected_is_overnight_work BOOLEAN DEFAULT 0 COMMENT "当日開業から翌日終業フラグ",
	corrected_is_night_shift BOOLEAN DEFAULT 0 COMMENT "深夜出勤フラグ",

    start_time_error_type VARCHAR(2) COMMENT "判定-開業時刻エラー種別",
    end_time_error_type VARCHAR(2) COMMENT "判定-終業時刻エラー種別",
	corrected_start_time VARCHAR(5) COMMENT "勤務票時間補正-開始時刻",
	corrected_end_time VARCHAR(5) COMMENT "勤務票時間補正-終了時刻",
	corrected_duration VARCHAR(5) COMMENT "勤務票時間補正-実労働時間",
	corrected_with_note VARCHAR(256) COMMENT "コメント",
    corrected_payment BOOLEAN DEFAULT NULL COMMENT '補正種別追納返納',
    corrected_holiday BOOLEAN DEFAULT NULL COMMENT '補正種別年休返還',
    corrected_other BOOLEAN DEFAULT NULL COMMENT '補正種別その他',

	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "登録日",
	created_by varchar(32) NOT NULL DEFAULT "system" COMMENT "登録者",
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新日",
	updated_by varchar(32) DEFAULT NULL COMMENT "更新者",
    deleted_at datetime DEFAULT NULL COMMENT "削除日",
	deleted_by varchar(32) DEFAULT NULL COMMENT "削除者"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS tbl_t_correction_approvals;
CREATE TABLE tbl_t_correction_approvals (
	id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "ID",
	timesheet_approval_id BIGINT NOT NULL COMMENT "勤怠承認ID",
	correction_type VARCHAR(2) NOT NULL COMMENT "補正種別",

	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "登録日",
	created_by varchar(32) NOT NULL DEFAULT "system" COMMENT "登録者",
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新日",
	updated_by varchar(32) DEFAULT NULL COMMENT "更新者",
    deleted_at datetime DEFAULT NULL COMMENT "削除日",
	deleted_by varchar(32) DEFAULT NULL COMMENT "削除者"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS tbl_t_leave_approvals;
CREATE TABLE tbl_t_leave_approvals (
	id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT "ID",
	timesheet_approval_id BIGINT NOT NULL COMMENT "外出歴史ID",
	timesheet_leave_id BIGINT NOT NULL COMMENT "レポート歴史ID",
	corrected_start_time VARCHAR(5) COMMENT "開始時刻",
	corrected_end_time VARCHAR(5) COMMENT "終了時刻",
	corrected_work_on_rest_time BOOLEAN COMMENT "休憩に働いたフラグ",
	corrected_duration VARCHAR(5) COMMENT "休憩に働いた時間",
	corrected_with_note VARCHAR(256) COMMENT "コメント",

	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "登録日",
	created_by varchar(32) NOT NULL DEFAULT "system" COMMENT "登録者",
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新日",
	updated_by varchar(32) DEFAULT NULL COMMENT "更新者",
    deleted_at datetime DEFAULT NULL COMMENT "削除日",
	deleted_by varchar(32) DEFAULT NULL COMMENT "削除者"
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
