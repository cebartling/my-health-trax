databaseChangeLog() {
    changeSet(id: '201909100154', author: 'cebartling') {
        createTable(tableName: 'user_accounts') {
            column(name: 'id', type: 'bigint', autoIncrement: true) {
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'created_at', type: 'timestamp', defaultValueDate: 'now()')
            column(name: 'updated_at', type: 'timestamp', defaultValueDate: 'now()')
        }
    }
}