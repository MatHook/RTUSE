const {
    Entity,
    PrimaryGeneratedColumn,
    Column,
    BaseEntity,
} = require('typeorm');

@Entity()
class Student extends BaseEntity {
    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    name: string;

    @Column()
    city: string;

    @Column()
    birthday: string;
}

module.exports = Student;
