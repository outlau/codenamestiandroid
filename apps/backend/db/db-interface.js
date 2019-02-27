const knex = require("./knex-config");

class DbInterface {
  static async getCoordinates() {
    return knex.table("coordinates").select();
  }

  static async getTimes() {
    return knex("times").select();
  }

  static async getQuote() {
    return knex("quotes")
      .select("name")
      .orderBy("id", "desc")
      .limit(1);
  }

  static async getSti() {
    return knex("sti")
      .select()
      .limit(1);
  }

  static async updateSti(obj) {
    return knex("sti")
      .where({ id: obj.id })
      .update({
        name: obj.name,
        datetime: obj.datetime
      });
  }
}

module.exports = DbInterface;
