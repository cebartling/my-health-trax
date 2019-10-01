databaseChangeLog() {
    changeSet(id: '201909100154', author: 'cebartling') {
        createTable(tableName: 'user_accounts') {
            column(name: 'id', type: 'uuid', defaultValue: 'uuid_generate_v4()') {
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'given_name', type: 'nvarchar(40)') {
                constraints(nullable: false)
            }
            column(name: 'family_name', type: 'nvarchar(50)') {
                constraints(nullable: false)
            }
            column(name: 'locale', type: 'nvarchar(6)') {
                constraints(nullable: false)
            }
            column(name: 'email', type: 'nvarchar(300)') {
                constraints(nullable: false)
            }
            column(name: 'created_at', type: 'timestamp', defaultValueDate: 'now()')
            column(name: 'updated_at', type: 'timestamp', defaultValueDate: 'now()')
        }
        rollback() {
            dropTable(tableName: 'user_accounts')
        }
    }
}